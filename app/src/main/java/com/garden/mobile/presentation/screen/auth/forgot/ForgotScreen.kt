package com.garden.mobile.presentation.screen.auth.forgot

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.ProgressIndicator
import com.garden.mobile.presentation.screen.auth.forgot.viewmodel.ForgotState
import com.garden.mobile.presentation.screen.auth.forgot.viewmodel.ForgotViewModel

@Composable
fun ForgotScreen(
    onBackClick: () -> Unit,
    viewModel: ForgotViewModel = hiltViewModel(),
) {
    val state = viewModel.state.observeAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        when (state) {
            is ForgotState.Loading ->
                ProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    isLoading = state.isLoading,
                )

            is ForgotState.Data -> {
                ForgotForm(
                    viewModel,
                    state,
                    onBackClick,
                )
                BottomSheet(
                    isShow = state.results.status,
                    icon = Icons.AutoMirrored.Filled.Message,
                    text = state.results.message,
                    onButtonClick = { viewModel.onDismissErrorDialog() },
                )
            }

            is ForgotState.Forgot -> {
                onBackClick()
            }

            else -> {
                onBackClick()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewForgotScreen() {
    ForgotScreen(onBackClick = {})
}
