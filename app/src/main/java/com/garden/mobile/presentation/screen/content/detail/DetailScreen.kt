package com.garden.mobile.presentation.screen.content.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailScreen(onBackClick: () -> Unit) {
    onBackClick()
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailScreen() {
    DetailScreen(onBackClick = {})
}
