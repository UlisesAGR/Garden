package com.garden.mobile.presentation.screen.auth.create

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
import com.garden.mobile.presentation.navigation.interections.CreateInteractions
import com.garden.mobile.presentation.navigation.interections.SocialMediaInteractions
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateState
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateViewModel

@Composable
fun CreateScreen(
    createInteractions: CreateInteractions,
    viewModel: CreateViewModel = CreateViewModel(),
) {
    val state = viewModel.state.observeAsState(
        CreateState.Data(
            name = "",
            email = "",
            password = "",
            confirmPassword = "",
            isLoginEnable = false,
        )
    ).value
    var show by rememberSaveable { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        when (state) {
            is CreateState.Loading ->
                ProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    isLoading = state.isLoading,
                )

            is CreateState.Data ->
                CreateForm(
                    viewModel,
                    state,
                    createInteractions,
                    socialMediaInteractions = SocialMediaInteractions(
                        onFacebookClick = {},
                        onGmailClick = {},
                    )
                )

            is CreateState.Error ->
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
private fun PreviewCreateScreen() {
    CreateScreen(CreateInteractions(onBackClick = {}, onTermsClick = {}, onCreateClick = {}))
}
