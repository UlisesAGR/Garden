package com.garden.mobile.presentation.screen.content.plants

import androidx.activity.compose.ReportDrawnWhen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.presentation.common.PlantItem

@Composable
fun PlantsList(
    plants: List<Plant>,
    onClick: (Plant) -> Unit,
) {
    val gridState = rememberLazyGridState()
    ReportDrawnWhen { gridState.layoutInfo.totalItemsCount > 0 }

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        state = gridState,
        columns = GridCells.Fixed(2),
    ) {
        items(
            items = plants,
            key = { it.id },
        ) { item ->
            PlantItem(
                plant = item,
                onPlantClick = { plant ->
                    onClick(plant)
                },
            )
        }
    }
}
