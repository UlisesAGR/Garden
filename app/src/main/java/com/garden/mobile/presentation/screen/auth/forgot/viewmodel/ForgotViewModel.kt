package com.garden.mobile.presentation.screen.auth.forgot.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.usecase.validations.ValidateEmailUseCase
import com.garden.mobile.domian.utils.Constants
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForgotViewModel @Inject constructor(
    private val validateEmail: ValidateEmailUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<ForgotState>()
    val state: LiveData<ForgotState> = _state

    fun onEvent(email: String) =
        viewModelScope.launch {
            _state.value = ForgotState.Data(email = email)
        }

    fun validateForm(email: String) =
        viewModelScope.launch {
            val emailResult = validateEmail(email)

            val hasError = listOf(
                emailResult,
            ).any { !it.status }

            if (hasError) {
                _state.value = ForgotState.Data(
                    emailError = emailResult,
                )
            } else {
                onForgotPassword()
            }
        }

    private fun onForgotPassword() {
        _state.value = ForgotState.Forgot
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
            _state.value = ForgotState.Data(
                results = ValidationResults(
                    status = false,
                    message = Constants.EMPTY_STRING,
                )
            )
        }
}
