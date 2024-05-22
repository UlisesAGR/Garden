package com.garden.mobile.presentation.screen.content.detail.plant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.garden.mobile.R
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.presentation.common.ButtonPrimary
import com.garden.mobile.presentation.common.LoadImage

@Composable
fun PlantsDetailCard(
    plant: Plant,
    onButtonClick: () -> Unit,
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            plant.apply {
                LoadImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.plant_detail_height)),
                    data = imageUrl,
                    placeholder = android.R.drawable.progress_horizontal,
                    error = android.R.drawable.presence_offline,
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding))
                        .padding(top = dimensionResource(id = R.dimen.padding)),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleLarge,
                    text = name,
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding)),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.labelSmall,
                    text = type,
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding))
                        .padding(top = dimensionResource(id = R.dimen.padding)),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.titleSmall,
                    text = stringResource(id = R.string.watering_needs),
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding)),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.labelSmall,
                    text = pluralStringResource(R.plurals.watering_needs, wateringInterval),
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.padding)),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.labelSmall,
                    text = description,
                )
            }
            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding)),
                text = stringResource(R.string.planing_from_my_garden),
                onClick = { onButtonClick() },
            )
        }
    }
}
