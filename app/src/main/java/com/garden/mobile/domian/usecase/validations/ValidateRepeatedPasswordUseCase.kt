package com.garden.mobile.domian.usecase.validations

import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.provider.ResourceProvider
import javax.inject.Inject

class ValidateRepeatedPasswordUseCase @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    operator fun invoke(
        password: String,
        repeatedPassword: String,
    ): ValidationResults =
        when {
            repeatedPassword.isBlank() ->
                ValidationResults(
                    status = false,
                    message = resourceProvider.passwordEmptyLabel(),
                )

            password != repeatedPassword ->
                ValidationResults(
                    status = false,
                    message = resourceProvider.passwordNeedSame(),
                )

            else -> ValidationResults(status = true)
        }
}
