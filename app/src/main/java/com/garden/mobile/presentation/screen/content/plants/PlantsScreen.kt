package com.garden.mobile.presentation.screen.content.plants

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.domian.Plant
import com.garden.mobile.presentation.common.EmptyPlants
import com.garden.mobile.ui.utils.getPlants

@Composable
fun PlantsScreen(onPlantClick: (Plant) -> Unit) {
    val plants = getPlants()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_small)),
    ) {
        if (plants.isNotEmpty()) {
            PlantsList(
                plants,
                onClick = { plant ->
                    onPlantClick(plant)
                },
            )
        } else {
            EmptyPlants(modifier = Modifier.fillMaxSize())
        }
        //PlantsShimmerEffect(isLoading = true)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPlantsScreen() {
    PlantsScreen(onPlantClick = {})
}
