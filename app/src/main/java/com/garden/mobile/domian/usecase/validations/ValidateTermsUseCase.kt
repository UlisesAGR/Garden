package com.garden.mobile.domian.usecase.validations

import com.garden.mobile.domian.model.ValidationResults
import com.garden.mobile.domian.provider.ResourceProvider
import javax.inject.Inject

class ValidateTermsUseCase @Inject constructor(
    private val resourceProvider: ResourceProvider,
) {
    operator fun invoke(terms: Boolean): ValidationResults =
        when {
            !terms ->
                ValidationResults(
                    status = false,
                    message = resourceProvider.acceptTerms(),
                )

            else -> ValidationResults(status = true)
        }
}
