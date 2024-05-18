package com.garden.mobile.presentation.screen.content.detail.plant

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.garden.mobile.R
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.ProgressIndicator
import com.garden.mobile.presentation.common.TopBarSimple
import com.garden.mobile.presentation.screen.content.detail.plant.viewmodel.PlantsDetailState
import com.garden.mobile.presentation.screen.content.detail.plant.viewmodel.PlantsDetailViewModel
import com.garden.mobile.ui.utils.UIComponent
import com.garden.mobile.ui.utils.showToast

@Composable
fun PlantsDetailScreen(
    onBackClick: () -> Unit,
    viewModel: PlantsDetailViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val state = viewModel.state.observeAsState(PlantsDetailState.Loading(isLoading = true)).value
    val sideEffect = viewModel.components.observeAsState().value
    var show by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(key1 = sideEffect) {
        sideEffect?.let {
            when (sideEffect) {
                is UIComponent.Toast ->
                    context.showToast(sideEffect.message)
            }
        }
    }

    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
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
            when (state) {
                is PlantsDetailState.Loading ->
                    ProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        isLoading = state.isLoading,
                    )

                is PlantsDetailState.Data ->
                    PlantsDetailCard(
                        plant = state.plant,
                        onButtonClick = {
                            viewModel.addPlantToGarden()
                        },
                    )

                is PlantsDetailState.Error ->
                    BottomSheet(
                        isShow = show,
                        icon = Icons.AutoMirrored.Filled.Message,
                        text = state.message,
                        onButtonClick = {
                            show = false
                            onBackClick()
                        },
                    )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPlantsDetailScreen() {
    PlantsDetailScreen(onBackClick = {})
}
