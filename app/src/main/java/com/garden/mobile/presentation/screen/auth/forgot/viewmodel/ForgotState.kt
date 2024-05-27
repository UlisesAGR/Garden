package com.garden.mobile.presentation.screen.auth.forgot.viewmodel

import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.utils.Constants

private val generic = ValidationResults(status = false, message = null)

sealed class ForgotState {
    internal data class Loading(
        val isLoading: Boolean = false,
    ) : ForgotState()

    data class Data(
        val email: String = Constants.EMPTY_STRING,
        val emailError: ValidationResults = generic,
        val results: ValidationResults = generic,
    ) : ForgotState()

    internal data object Forgot : ForgotState()
}
