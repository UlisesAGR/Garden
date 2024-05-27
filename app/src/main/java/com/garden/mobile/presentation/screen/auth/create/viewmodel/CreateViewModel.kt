package com.garden.mobile.presentation.screen.auth.create.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.usecase.validations.ValidateEmailUseCase
import com.garden.mobile.domian.usecase.validations.ValidatePasswordUseCase
import com.garden.mobile.domian.usecase.validations.ValidateRepeatedPasswordUseCase
import com.garden.mobile.domian.usecase.validations.ValidateTermsUseCase
import com.garden.mobile.domian.utils.Constants.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val validateEmail: ValidateEmailUseCase,
    private val validatePassword: ValidatePasswordUseCase,
    private val validateRepeatedPasswordUseCase: ValidateRepeatedPasswordUseCase,
    private val validateTermsUseCase: ValidateTermsUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<CreateState>()
    val state: LiveData<CreateState> = _state

    fun onEvent(event: CreateFormEvent) =
        viewModelScope.launch {
            when (event) {
                is CreateFormEvent.EmailChanged ->
                    _state.value = CreateState.Data(email = event.email)

                is CreateFormEvent.PasswordChanged ->
                    _state.value = CreateState.Data(password = event.password)

                is CreateFormEvent.RepeatedPasswordChanged ->
                    _state.value = CreateState.Data(repeatedPassword = event.repeatedPassword)

                is CreateFormEvent.AcceptTerms ->
                    _state.value = CreateState.Data(terms = event.isAccepted)

            }
        }

    fun validateForm(
        email: String,
        password: String,
        repeatedPassword: String,
        terms: Boolean,
    ) = viewModelScope.launch {
        val emailResult = validateEmail(email)
        val passwordResult = validatePassword(password)
        val repeatedPasswordResult = validateRepeatedPasswordUseCase(password, repeatedPassword)
        val termsResult = validateTermsUseCase(terms)

        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult,
        ).any { !it.status }

        if (hasError) {
            _state.value = CreateState.Data(
                emailError = emailResult,
                passwordError = passwordResult,
                repeatedPasswordError = repeatedPasswordResult,
                termsError = termsResult,
            )
        } else {
            onCreateUser()
        }
    }

    private fun onCreateUser() {
        _state.value = CreateState.Created
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
            _state.value = CreateState.Data(
                results = ValidationResults(
                    status = false,
                    message = EMPTY_STRING,
                )
            )
        }
}
