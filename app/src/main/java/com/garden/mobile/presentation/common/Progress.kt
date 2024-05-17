package com.garden.mobile.presentation.common

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
) {
    if (isLoading) {
        CircularProgressIndicator(
            modifier = modifier,
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProgressIndicator() {
    ProgressIndicator(isLoading = true)
}