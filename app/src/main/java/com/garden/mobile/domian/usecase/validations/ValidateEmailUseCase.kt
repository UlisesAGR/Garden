package com.garden.mobile.domian.usecase.validations

import android.util.Patterns
import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.provider.ResourceProvider
import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    operator fun invoke(email: String): ValidationResults =
        when {
            email.isBlank() ->
                ValidationResults(
                    status = false,
                    message = resourceProvider.emailEmptyLabel(),
                )

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                ValidationResults(
                    status = false,
                    message = resourceProvider.emailInvalidLabel(),
                )

            else -> ValidationResults(status = true)
        }
}
