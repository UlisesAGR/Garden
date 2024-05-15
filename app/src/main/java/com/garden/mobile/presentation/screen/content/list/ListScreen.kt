package com.garden.mobile.presentation.screen.content.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.domian.Plant

@Composable
fun ListScreen(onPlantClick: (Plant) -> Unit) {

}

@Preview(showBackground = true)
@Composable
private fun PreviewListScreen() {
    ListScreen(onPlantClick = {})
}
