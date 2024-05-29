package com.garden.mobile.presentation.screen.auth.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.usecase.validations.ValidateEmailUseCase
import com.garden.mobile.domian.usecase.validations.ValidatePasswordUseCase
import com.garden.mobile.domian.utils.Constants
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val validateEmail: ValidateEmailUseCase,
    private val validatePassword: ValidatePasswordUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState> = _state

    fun onEvent(event: LoginFormEvent) =
        viewModelScope.launch {
            when (event) {
                is LoginFormEvent.EmailChanged ->
                    _state.value = LoginState.Data(email = event.email)

                is LoginFormEvent.PasswordChanged ->
                    _state.value = LoginState.Data(password = event.password)
            }
        }

    fun validateForm(
        email: String,
        password: String,
    ) = viewModelScope.launch {
        val emailResult = validateEmail(email)
        val passwordResult = validatePassword(password)
        val hasError = listOf(
            emailResult,
            passwordResult,
        ).any { !it.status }

        if (hasError) {
            _state.value = LoginState.Data(
                emailError = emailResult,
                passwordError = passwordResult,
            )
        } else {
            onLoginUser()
        }
    }

    private fun onLoginUser() {
        _state.value = LoginState.Login
    }

    /*private fun onShowErrorDialog() =
    viewModelScope.launch {
        _state.value = CreateState.Data(
            results = ValidationResults(
                status = true,
                message = EMPTY_STRING,
            )
        )
    }*/

    fun onDismissErrorDialog() =
        viewModelScope.launch {
            _state.value = LoginState.Data(
                results = ValidationResults(
                    status = false,
                    message = Constants.EMPTY_STRING,
                )
            )
        }
}
