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
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import com.garden.mobile.R
import com.garden.mobile.domian.Plant

@Composable
fun GardenItem(
    plant: Plant,
    onPlantClick: (Plant) -> Unit,
) {
    ElevatedCard(
        onClick = { onPlantClick(plant) },
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(Modifier.fillMaxWidth()) {
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
                        .padding(vertical = dimensionResource(id = R.dimen.padding))
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.titleMedium,
                    text = name,
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.titleSmall,
                    text = stringResource(R.string.planted),
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.labelSmall,
                    text = plantDate,
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = dimensionResource(id = R.dimen.padding)),
                    style = MaterialTheme.typography.titleSmall,
                    text = stringResource(R.string.irrigate),
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = dimensionResource(id = R.dimen.padding)),
                    style = MaterialTheme.typography.labelSmall,
                    text = pluralStringResource(
                        id = R.plurals.watering_next,
                        count = wateringInterval,
                        wateringInterval,
                    ),
                )
            }
        }
    }
}
