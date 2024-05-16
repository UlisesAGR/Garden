package com.garden.mobile.presentation.screen.content.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.presentation.common.TopBarSimple
import com.garden.mobile.ui.utils.getPlant

@Composable
fun DetailScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(id = R.dimen.padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopBarSimple(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = { onBackClick() },
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dimensionResource(id = R.dimen.padding)),
        ) {
            DetailCard(
                plant = getPlant(),
                onFavoriteClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailScreen() {
    DetailScreen(onBackClick = {})
}
