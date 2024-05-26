package com.garden.mobile.domian.usecase.validations

import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.provider.ResourceProvider
import com.garden.mobile.domian.utils.Constants
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    operator fun invoke(password: String): ValidationResults =
        when {
            password.isBlank() ->
                ValidationResults(
                    status = false,
                    message = resourceProvider.passwordEmptyLabel(),
                )

            password.length < Constants.PASSWORD_LENGTH ->
                ValidationResults(
                    status = false,
                    message = resourceProvider.passwordInvalidLabel(),
                )

            else -> ValidationResults(status = true)
        }
}
