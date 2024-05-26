package com.garden.mobile.presentation.screen.auth.forgot.viewmodel

sealed class ForgotState {
    internal data class Loading(
        val isLoading: Boolean = false,
    ) : ForgotState()

    data class Form(
        val email: String,
        val isForgotEnable: Boolean,
    ) : ForgotState()

    internal data object Forgot : ForgotState()

    internal data class Error(
        val status: Boolean = false,
        val message: String,
    ) : ForgotState()
}
