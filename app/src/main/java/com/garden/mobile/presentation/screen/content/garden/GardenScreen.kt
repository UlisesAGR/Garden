package com.garden.mobile.presentation.screen.content.garden

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.domian.Plant
import com.garden.mobile.presentation.common.EmptyGarden
import com.garden.mobile.ui.utils.getPlants

@Composable
fun GardenScreen(
    onAddPlantClick: () -> Unit,
    onPlantClick: (Plant) -> Unit,
) {
    val plants = getPlants()
    if (plants.isEmpty()) {
        EmptyGarden(
            modifier = Modifier.fillMaxSize(),
            onAddPlantClick = { onAddPlantClick() }
        )
    } else {
        GardenList(
            plants,
            onPlantClick = { plant ->
                onPlantClick(plant)
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGardenScreen() {
    GardenScreen(onAddPlantClick = {}, onPlantClick = {})
}
