package com.garden.mobile.presentation.screen.content.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.domian.Plant
import com.garden.mobile.presentation.common.LoadImage
import com.garden.mobile.ui.utils.getPlant

@Composable
fun DetailCard(
    plant: Plant,
    onFavoriteClick: () -> Unit,
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            plant.apply {
                LoadImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.plant_detail_height)),
                    data = imageUrl,
                    placeholder = android.R.drawable.progress_horizontal,
                    error = android.R.drawable.presence_offline,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.padding)),
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.titleLarge,
                            text = name,
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.labelSmall,
                            text = type,
                        )
                    }
                    FloatingActionButton(
                        onClick = { onFavoriteClick() },
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.onBackground,
                    ) {
                        Icon(
                            modifier = Modifier.size(dimensionResource(id = R.dimen.icon)),
                            painter = painterResource(id = R.drawable.ic_outline_favorite),
                            contentDescription = null,
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding)),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.titleMedium,
                    text = stringResource(id = R.string.watering_needs),
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding)),
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.labelMedium,
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
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailCard() {
    DetailCard(plant = getPlant(), onFavoriteClick = {})
}
