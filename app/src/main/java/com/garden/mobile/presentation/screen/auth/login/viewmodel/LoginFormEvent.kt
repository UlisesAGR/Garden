package com.garden.mobile.presentation.screen.auth.login.viewmodel

sealed class LoginFormEvent {
    data class EmailChanged(val email: String) : LoginFormEvent()
    data class PasswordChanged(val password: String) : LoginFormEvent()
}
