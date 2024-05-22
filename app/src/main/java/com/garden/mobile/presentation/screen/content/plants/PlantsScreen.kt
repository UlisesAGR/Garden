package com.garden.mobile.presentation.screen.content.plants

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.EmptyPlants
import com.garden.mobile.presentation.common.PlantsShimmerEffect
import com.garden.mobile.presentation.screen.content.plants.viewmodel.PlantsState
import com.garden.mobile.presentation.screen.content.plants.viewmodel.PlantsViewModel

@Composable
fun PlantsScreen(
    onListClick: (Plant) -> Unit,
    viewModel: PlantsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.observeAsState(PlantsState.Loading(isLoading = true)).value
    var show by rememberSaveable { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is PlantsState.Loading ->
                PlantsShimmerEffect(state.isLoading)

            is PlantsState.Data -> {
                val plants = state.plants
                if (plants.isNotEmpty()) {
                    PlantsList(
                        plants,
                        onClick = { plant ->
                            onListClick(plant)
                        },
                    )
                } else {
                    EmptyPlants(modifier = Modifier.fillMaxSize())
                }
            }

            is PlantsState.Error ->
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
private fun PreviewPlantsScreen() {
    PlantsScreen(onListClick = {})
}
