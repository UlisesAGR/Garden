package com.garden.mobile.presentation.screen.content.garden

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
import com.garden.mobile.R
import com.garden.mobile.domian.Plant
import com.garden.mobile.presentation.common.GardenItem

@Composable
fun GardenList(
    plants: List<Plant>,
    onPlantClick: (Plant) -> Unit,
) {
    val gridState = rememberLazyGridState()
    ReportDrawnWhen { gridState.layoutInfo.totalItemsCount > 0 }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.imePadding(),
        state = gridState,
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.margin)),
    ) {
        items(
            items = plants,
            key = { it.id },
        ) { item ->
            GardenItem(
                plant = item,
                onPlantClick = { plant ->
                    onPlantClick(plant)
                }
            )
        }
    }
}
