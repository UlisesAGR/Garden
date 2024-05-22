package com.garden.mobile.presentation.screen.auth.create.viewmodel

sealed class CreateState {
    internal data class Loading(
        val isLoading: Boolean = false,
    ) : CreateState()

    data class Data(
        val name: String,
        val email: String,
        val password: String,
        val confirmPassword: String,
        val isLoginEnable: Boolean,
    ) : CreateState()

    internal data class Error(
        val message: String,
    ) : CreateState()
}
