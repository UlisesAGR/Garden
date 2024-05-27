package com.garden.mobile.presentation.screen.auth.create.viewmodel

sealed class CreateFormEvent {
    data class EmailChanged(val email: String) : CreateFormEvent()
    data class PasswordChanged(val password: String) : CreateFormEvent()
    data class RepeatedPasswordChanged(val repeatedPassword: String) : CreateFormEvent()
    data class AcceptTerms(val isAccepted: Boolean) : CreateFormEvent()
}
