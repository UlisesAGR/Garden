package com.garden.mobile.presentation.screen.auth.create

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.ProgressIndicator
import com.garden.mobile.presentation.navigation.interections.CreateInteractions
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateViewModel

@Composable
fun CreateScreen(
    createInteractions: CreateInteractions,
    viewModel: CreateViewModel = hiltViewModel(),
) = with(viewModel.state) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        CreateForm(
            viewModel,
            state = this@with,
            createInteractions = createInteractions,
        )
        BottomSheet(
            isShow = errorDialog.status,
            icon = Icons.AutoMirrored.Filled.Message,
            text = errorDialog.message,
            onButtonClick = { viewModel.onDismissErrorDialog() },
        )
        ProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            isLoading = isLoading,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCreateScreen() {
    CreateScreen(CreateInteractions(onBackClick = {}, onTermsClick = {}))
}
