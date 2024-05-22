package com.garden.mobile.presentation.screen.auth.forgot

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.ProgressIndicator
import com.garden.mobile.presentation.screen.auth.forgot.viewmodel.ForgotState
import com.garden.mobile.presentation.screen.auth.forgot.viewmodel.ForgotViewModel

@Composable
fun ForgotScreen(
    onBackClick: () -> Unit,
    viewModel: ForgotViewModel = ForgotViewModel(),
) {
    val state = viewModel.state.observeAsState(
        ForgotState.Data(
            email = "",
            isForgotEnable = false,
        )
    ).value
    var show by rememberSaveable { mutableStateOf(true) }

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

            is ForgotState.Data ->
                ForgotForm(
                    viewModel,
                    state,
                    onBackClick,
                    onForgotClick = {},
                )

            is ForgotState.Error ->
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
private fun PreviewForgotScreen() {
    ForgotScreen(onBackClick = {})
}
