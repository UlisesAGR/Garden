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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.garden.mobile.R
import com.garden.mobile.ui.utils.shimmer

@Composable
fun GardenShimmerEffect(isLoading: Boolean) {
    if (isLoading) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(2),
        ) {
            items(
                count = 10,
            ) {
                GardenShimmer()
            }
        }
    }
}

@Composable
private fun GardenShimmer(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
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
                    .height(28.dp)
                    .shimmer(),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(20.dp)
                    .shimmer(),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = dimensionResource(id = R.dimen.padding_small_extra))
                    .height(18.dp)
                    .shimmer(),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(top = dimensionResource(id = R.dimen.padding))
                    .height(20.dp)
                    .shimmer(),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_small_extra),
                        bottom = dimensionResource(id = R.dimen.padding),
                    )
                    .height(18.dp)
                    .shimmer(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGardenShimmer(modifier: Modifier = Modifier) {
    GardenShimmer(modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding)))
}

@Preview(showBackground = true)
@Composable
private fun PreviewGardenShimmerEffect(modifier: Modifier = Modifier) {
    GardenShimmerEffect(isLoading = true)
}
