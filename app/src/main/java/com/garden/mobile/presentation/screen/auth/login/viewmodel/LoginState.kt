package com.garden.mobile.presentation.screen.auth.login.viewmodel

sealed class LoginState {
    internal data class Loading(
        val isLoading: Boolean = false,
    ) : LoginState()

    data class Data(
        val email: String,
        val password: String,
        val isLoginEnable: Boolean,
    ) : LoginState()

    internal data class Error(
        val message: String,
    ) : LoginState()
}
