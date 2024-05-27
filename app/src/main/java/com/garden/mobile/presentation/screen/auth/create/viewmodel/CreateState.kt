package com.garden.mobile.presentation.screen.auth.create.viewmodel

import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.utils.Constants.EMPTY_STRING

private val generic = ValidationResults(status = false, message = null)

sealed class CreateState {
    internal data class Loading(
        val isLoading: Boolean = false,
    ) : CreateState()

    data class Data(
        val email: String = EMPTY_STRING,
        val emailError: ValidationResults = generic,
        val password: String = EMPTY_STRING,
        val passwordError: ValidationResults = generic,
        val repeatedPassword: String = EMPTY_STRING,
        val repeatedPasswordError: ValidationResults = generic,
        val terms: Boolean = false,
        val termsError: ValidationResults = generic,
        val results: ValidationResults = generic,
    ) : CreateState()

    internal data object Created : CreateState()
}
