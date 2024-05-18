package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.garden.mobile.R
import com.garden.mobile.domian.model.Plant

@Composable
fun PlantItem(
    plant: Plant,
    onPlantClick: (Plant) -> Unit,
) {
    ElevatedCard(
        onClick = { onPlantClick(plant) },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            plant.apply {
                LoadImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.plant_item_image_height)),
                    data = imageUrl,
                    placeholder = android.R.drawable.progress_horizontal,
                    error = android.R.drawable.presence_offline,
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(dimensionResource(id = R.dimen.padding)),
                    style = MaterialTheme.typography.titleMedium,
                    text = name,
                )
            }
        }
    }
}
