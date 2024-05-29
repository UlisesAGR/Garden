package com.garden.mobile.presentation.screen.auth.login.viewmodel

import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.utils.Constants

private val generic = ValidationResults(status = false, message = null)

sealed class LoginState {
    internal data class Loading(
        val isLoading: Boolean = false,
    ) : LoginState()

    data class Data(
        val email: String = Constants.EMPTY_STRING,
        val emailError: ValidationResults = generic,
        val password: String = Constants.EMPTY_STRING,
        val passwordError: ValidationResults = generic,
        val results: ValidationResults = generic,
    ) : LoginState()

    internal data object Login : LoginState()
}
