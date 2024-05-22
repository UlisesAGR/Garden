package com.garden.mobile.presentation.navigation.interections

data class CreateInteractions(
    val onBackClick: () -> Unit,
    val onTermsClick: () -> Unit,
    val onCreateClick: () -> Unit,
)
