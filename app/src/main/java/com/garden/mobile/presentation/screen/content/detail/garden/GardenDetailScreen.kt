package com.garden.mobile.presentation.screen.content.detail.garden

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.garden.mobile.presentation.screen.content.detail.garden.viewmodel.GardenDetailState
import com.garden.mobile.presentation.screen.content.detail.garden.viewmodel.GardenDetailViewModel
import com.garden.mobile.ui.utils.UIComponent
import com.garden.mobile.ui.utils.showToast

@Composable
fun GardenDetailScreen(
    onBackClick: () -> Unit,
    viewModel: GardenDetailViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val state = viewModel.state.observeAsState(GardenDetailState.Loading(isLoading = true)).value
    val sideEffect = viewModel.components.observeAsState().value
    var show by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(key1 = sideEffect) {
        sideEffect?.let {
            when (sideEffect) {
                is UIComponent.Toast -> {
                    context.showToast(sideEffect.message)
                    onBackClick()
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        TopBarSimple(
            modifier = Modifier.padding(
                top = dimensionResource(id = R.dimen.padding),
                end = dimensionResource(id = R.dimen.padding),
                start = dimensionResource(id = R.dimen.padding),
            ),
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = { onBackClick() },
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding)),
        ) {
            when (state) {
                is GardenDetailState.Loading ->
                    ProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        isLoading = state.isLoading,
                    )

                is GardenDetailState.Data ->
                    GardenDetailCard(
                        plant = state.plant,
                        onButtonClick = {
                            viewModel.deletePlantToGarden()
                        },
                    )

                is GardenDetailState.Error ->
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
private fun PreviewGardenDetailScreen() {
    GardenDetailScreen(onBackClick = {})
}
