package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.garden.mobile.R
import com.garden.mobile.ui.utils.shimmer

@Composable
fun PlantsShimmerEffect(isLoading: Boolean) {
    if (isLoading) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(2),
        ) {
            items(
                count = 10,
            ) {
                PlantsShimmer()
            }
        }
    }
}

@Composable
private fun PlantsShimmer(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.plant_item_image_height))
                    .shimmer(),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding))
                    .height(27.dp)
                    .shimmer(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCharacterShimmer(modifier: Modifier = Modifier) {
    PlantsShimmer(modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding)))
}

@Preview(showBackground = true)
@Composable
private fun PreviewPlantsShimmerEffect(modifier: Modifier = Modifier) {
    PlantsShimmerEffect(isLoading = true)
}
