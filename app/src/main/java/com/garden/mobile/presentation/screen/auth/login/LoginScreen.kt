package com.garden.mobile.presentation.screen.auth.login

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
import com.garden.mobile.presentation.navigation.interections.LoginInteractions
import com.garden.mobile.presentation.screen.auth.login.viewmodel.LoginState
import com.garden.mobile.presentation.screen.auth.login.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    loginInteractions: LoginInteractions,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val state = viewModel.state.observeAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        when (state) {
            is LoginState.Loading -> {
                ProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    isLoading = state.isLoading,
                )
            }

            is LoginState.Data -> {
                LoginForm(
                    viewModel,
                    state,
                    loginInteractions = loginInteractions
                )
                BottomSheet(
                    isShow = state.results.status,
                    icon = Icons.AutoMirrored.Filled.Message,
                    text = state.results.message,
                    onButtonClick = { viewModel.onDismissErrorDialog() },
                )
            }

            is LoginState.Login -> {
                loginInteractions.onCreateClick()
            }

            else -> throw AssertionError()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen(LoginInteractions(onGardenClick = {}, onForgotClick = {}, onCreateClick = {}))
}
