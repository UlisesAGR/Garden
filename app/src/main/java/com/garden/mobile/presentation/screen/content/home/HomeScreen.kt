package com.garden.mobile.presentation.screen.content.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.Dialog
import com.garden.mobile.presentation.common.TopBar

@Composable
fun HomeScreen(
    onLogoutClick: () -> Unit,
    onGardenClick: (Plant) -> Unit,
    onPlantClick: (Plant) -> Unit,
) {
    var showDialog by rememberSaveable { mutableStateOf(false) }
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding)),
                title = stringResource(id = R.string.my_garden),
                icon = Icons.AutoMirrored.Filled.Help,
                onBackClick = { showDialog = true },
                onIconClick = { showBottomSheet = true },
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            HomePageScreen(innerPadding = padding, onGardenClick, onPlantClick)
            Dialog(
                isShow = showDialog,
                icon = Icons.AutoMirrored.Filled.Help,
                text = stringResource(R.string.you_re_sure_to_logout),
                textConfirmation = stringResource(R.string.accept),
                onConfirmation = {
                    showDialog = false
                    onLogoutClick()
                },
                onDismissRequest = { showDialog = false },
            )
            BottomSheet(
                isShow = showBottomSheet,
                icon = Icons.AutoMirrored.Filled.Help,
                text = stringResource(R.string.don_t_forget_to_water_your_plants),
                onButtonClick = { showBottomSheet = false },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNavigation() {
    HomeScreen(onLogoutClick = {}, onGardenClick = {}, onPlantClick = {})
}
