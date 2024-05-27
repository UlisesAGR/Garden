package com.garden.mobile.presentation.screen.auth.create

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.ProgressIndicator
import com.garden.mobile.presentation.navigation.interections.CreateInteractions
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateState
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateViewModel
import com.garden.mobile.ui.utils.showToast

@Composable
fun CreateScreen(
    createInteractions: CreateInteractions,
    viewModel: CreateViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    val state = viewModel.state.observeAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        when (state) {
            is CreateState.Loading -> {
                ProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    isLoading = state.isLoading,
                )
            }

            is CreateState.Data -> {
                LaunchedEffect(key1 = context) {
                    context.showToast(state.termsError.message)
                }
                CreateForm(
                    viewModel,
                    state,
                    createInteractions = createInteractions,
                )
                BottomSheet(
                    isShow = state.results.status,
                    icon = Icons.AutoMirrored.Filled.Message,
                    text = state.results.message,
                    onButtonClick = { viewModel.onDismissErrorDialog() },
                )
            }

            CreateState.Created -> {
                createInteractions.onBackClick()
            }

            else -> {
                createInteractions.onBackClick()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCreateScreen() {
    CreateScreen(CreateInteractions(onBackClick = {}, onTermsClick = {}))
}
