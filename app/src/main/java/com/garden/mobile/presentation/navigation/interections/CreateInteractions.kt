package com.garden.mobile.presentation.navigation.interections

data class CreateInteractions(
    val onBackClick: () -> Unit,
    val onTermsClick: (String) -> Unit,
)
