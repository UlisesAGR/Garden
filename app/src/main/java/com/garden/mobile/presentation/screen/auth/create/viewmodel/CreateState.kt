package com.garden.mobile.presentation.screen.auth.create.viewmodel

import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.utils.Constants.EMPTY_STRING

data class CreateState(
    val isLoading: Boolean = false,
    val email: String = EMPTY_STRING,
    val emailError: ValidationResults =
        ValidationResults(status = false, message = null),
    val password: String = EMPTY_STRING,
    val passwordError: ValidationResults =
        ValidationResults(status = false, message = null),
    val repeatedPassword: String = EMPTY_STRING,
    val repeatedPasswordError: ValidationResults =
        ValidationResults(status = false, message = null),
    val terms: Boolean = false,
    val termsError: ValidationResults =
        ValidationResults(status = false, message = null),
    val errorDialog: ValidationResults =
        ValidationResults(status = false, message = null),
)
