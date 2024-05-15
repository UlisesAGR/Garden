package com.garden.mobile.presentation.screen.content.garden

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GardenScreen(onLogoutClick: () -> Unit) {
    onLogoutClick()
}

@Preview(showBackground = true)
@Composable
private fun PreviewGardenScreen() {
    GardenScreen(onLogoutClick = {})
}
