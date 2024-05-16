package com.garden.mobile.presentation.screen.content.plants

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.domian.Plant

@Composable
fun PlantsScreen(onPlantClick: (Plant) -> Unit) {
    Text(text = "Plants")
}

@Preview(showBackground = true)
@Composable
private fun PreviewPlantsScreen() {
    PlantsScreen(onPlantClick = {})
}
