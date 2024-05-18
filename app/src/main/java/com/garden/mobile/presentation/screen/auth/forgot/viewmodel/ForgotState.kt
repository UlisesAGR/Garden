package com.garden.mobile.presentation.screen.auth.forgot.viewmodel

sealed class ForgotState {
    internal data class Loading(
        val isLoading: Boolean = false,
    ) : ForgotState()

    data class Data(
        val email: String,
        val isForgotEnable: Boolean,
    ) : ForgotState()

    internal data class Error(
        val message: String,
    ) : ForgotState()
}
