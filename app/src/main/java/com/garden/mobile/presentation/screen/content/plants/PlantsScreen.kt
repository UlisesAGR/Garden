package com.garden.mobile.presentation.screen.content.plants

import androidx.activity.compose.ReportDrawnWhen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.domian.Plant
import com.garden.mobile.presentation.common.PlantItem
import com.garden.mobile.ui.utils.getPlants

@Composable
fun PlantsScreen(onPlantClick: (Plant) -> Unit) {
    val gridState = rememberLazyGridState()
    ReportDrawnWhen { gridState.layoutInfo.totalItemsCount > 0 }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.imePadding(),
        state = gridState,
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
    ) {
        items(
            items = getPlants(),
            key = { it.id },
        ) { item ->
            PlantItem(
                plant = item,
                onPlantClick = { plant ->
                    onPlantClick(plant)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPlantsScreen() {
    PlantsScreen(onPlantClick = {})
}
