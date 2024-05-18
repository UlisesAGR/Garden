package com.garden.mobile.presentation.screen.auth.login

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.presentation.common.BottomSheet
import com.garden.mobile.presentation.common.ProgressIndicator
import com.garden.mobile.presentation.navigation.interections.LoginInteractions
import com.garden.mobile.presentation.screen.auth.login.viewmodel.LoginState
import com.garden.mobile.presentation.screen.auth.login.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    loginInteractions: LoginInteractions,
    viewModel: LoginViewModel = LoginViewModel(),
) {
    val state = viewModel.state.observeAsState(
        LoginState.Data(
            email = "",
            password = "",
            isLoginEnable = false,
        )
    ).value
    var show by rememberSaveable { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimensionResource(id = R.dimen.padding)),
    ) {
        when (state) {
            is LoginState.Loading ->
                ProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    isLoading = state.isLoading,
                )

            is LoginState.Data ->
                LoginForm(
                    viewModel,
                    state,
                    loginInteractions,
                )

            is LoginState.Error ->
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
private fun PreviewLoginScreen() {
    LoginScreen(LoginInteractions(onGardenClick = {}, onForgotClick = {}, onCreateClick = {}))
}
