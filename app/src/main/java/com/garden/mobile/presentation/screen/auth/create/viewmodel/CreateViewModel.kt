package com.garden.mobile.presentation.screen.auth.create.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    var state by mutableStateOf(CreateState())

    fun onEvent(event: CreateFormEvent) =
        viewModelScope.launch {
            when (event) {
                is CreateFormEvent.EmailChanged ->
                    state = state.copy(email = event.email)

                is CreateFormEvent.PasswordChanged ->
                    state = state.copy(password = event.password)

                is CreateFormEvent.RepeatedPasswordChanged ->
                    state = state.copy(repeatedPassword = event.repeatedPassword)

                is CreateFormEvent.AcceptTerms ->
                    state = state.copy(terms = event.isAccepted)

                is CreateFormEvent.ValidateForm -> validateForm()
            }
        }

    private fun validateForm() =
        viewModelScope.launch {
            val emailResult =
                validateEmail(state.email)
            val passwordResult =
                validatePassword(state.password)
            val repeatedPasswordResult =
                validateRepeatedPasswordUseCase(state.password, state.repeatedPassword)
            val termsResult =
                validateTermsUseCase(state.terms)

            val hasError = listOf(
                emailResult,
                passwordResult,
                repeatedPasswordResult,
                termsResult,
            ).any { !it.status }

            if (hasError) {
                state = state.copy(
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
        onShowErrorDialog()
    }

    private fun onShowErrorDialog() =
        viewModelScope.launch {
            state = state.copy(
                errorDialog = ValidationResults(
                    status = true,
                    message = EMPTY_STRING,
                )
            )
        }

    fun onDismissErrorDialog() =
        viewModelScope.launch {
            state = state.copy(
                errorDialog = ValidationResults(
                    status = false,
                    message = EMPTY_STRING,
                )
            )
        }
}
