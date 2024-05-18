package com.garden.mobile.presentation.screen.content.garden

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.garden.mobile.R
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.EmptyGarden
import com.garden.mobile.presentation.common.GardenShimmerEffect
import com.garden.mobile.presentation.screen.content.garden.viewmodel.GardenState
import com.garden.mobile.presentation.screen.content.garden.viewmodel.GardenViewModel

@Composable
fun GardenScreen(
    onAddPlantClick: () -> Unit,
    onListClick: (Plant) -> Unit,
    viewModel: GardenViewModel = hiltViewModel(),
) {
    val state = viewModel.state.observeAsState(GardenState.Loading(isLoading = true)).value
    var show by rememberSaveable { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_small)),
    ) {
        when (state) {
            is GardenState.Loading ->
                GardenShimmerEffect(state.isLoading)

            is GardenState.Data -> {
                val plants = state.plants
                if (plants.isNotEmpty()) {
                    GardenList(
                        plants,
                        onPlantClick = { plant ->
                            onListClick(plant)
                        },
                    )
                } else {
                    EmptyGarden(
                        modifier = Modifier.fillMaxSize(),
                        onAddPlantClick = { onAddPlantClick() },
                    )
                }
            }

            is GardenState.Error ->
                BottomSheet(
                    isShow = show,
                    icon = Icons.AutoMirrored.Filled.Message,
                    text = state.message,
                    onButtonClick = { show = false },
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewGardenScreen() {
    GardenScreen(onAddPlantClick = {}, onListClick = {})
}
