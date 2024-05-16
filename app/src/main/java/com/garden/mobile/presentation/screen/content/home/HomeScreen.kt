package com.garden.mobile.presentation.screen.content.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.presentation.common.TopBar

@Composable
fun HomeScreen(onLogoutClick: () -> Unit) {
    Scaffold(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        topBar = {
            TopBar(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding)),
                title = stringResource(id = R.string.my_garden),
                icon = Icons.AutoMirrored.Filled.Help,
                onBackClick = { onLogoutClick() },
                onIconClick = {},
            )
        }
    ) { padding ->
        HomePageScreen(innerPadding = padding)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNavigation() {
    HomeScreen(onLogoutClick = {})
}
