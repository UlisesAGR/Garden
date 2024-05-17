package com.garden.mobile.presentation.common

import androidx.activity.compose.ReportDrawn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.garden.mobile.R

@Composable
fun EmptyPlants(modifier: Modifier = Modifier) {
    ReportDrawn()
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.padding_big),
            alignment = Alignment.CenterVertically,
        ),
    ) {
        Text(
            text = stringResource(id = R.string.plants_empty),
            style = MaterialTheme.typography.headlineSmall
        )
    }
}
