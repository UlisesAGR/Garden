package com.garden.mobile.presentation.screen.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import com.garden.mobile.R
import com.garden.mobile.presentation.common.ButtonPrimaryEnable
import com.garden.mobile.presentation.common.ButtonText
import com.garden.mobile.presentation.common.ButtonTextColor
import com.garden.mobile.presentation.common.DividerText
import com.garden.mobile.presentation.common.EmailField
import com.garden.mobile.presentation.common.PasswordField
import com.garden.mobile.presentation.common.SocialMediaList
import com.garden.mobile.presentation.navigation.interections.LoginInteractions
import com.garden.mobile.presentation.screen.auth.login.viewmodel.LoginState
import com.garden.mobile.presentation.screen.auth.login.viewmodel.LoginViewModel

@Composable
fun LoginForm(
    viewModel: LoginViewModel,
    state: LoginState.Data,
    loginInteractions: LoginInteractions,
) {
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding))
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_big)),
    ) {
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_extra)))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            text = stringResource(R.string.nice_to_see_you_again),
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall,
            text = stringResource(R.string.welcome_back_a_hava_a_nice_day),
        )
        EmailField(
            state.email,
            imeAction = ImeAction.Next,
            onTextFieldChanged = { viewModel.onLoginChanged(it, state.password) },
        )
        PasswordField(
            text = stringResource(R.string.password),
            imeAction = ImeAction.Done,
            state.password,
            supportingText = stringResource(R.string._6_character_password),
            onTextFieldChanged = { viewModel.onLoginChanged(state.email, it) },
        )
        ButtonText(
            modifier = Modifier.align(Alignment.End),
            text = stringResource(R.string.forgot_password),
            onClick = { loginInteractions.onForgotClick() },
        )
        ButtonPrimaryEnable(
            text = stringResource(R.string.login),
            enable = state.isLoginEnable,
            onClick = { loginInteractions.onGardenClick() },
        )
        DividerText(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small)),
            text = stringResource(R.string.or_continue_with),
        )
        SocialMediaList(
            modifier = Modifier.fillMaxWidth(),
            onFacebook = {},
            onGoogle = {},
        )
        ButtonTextColor(
            modifier = Modifier.fillMaxWidth(),
            textStart = stringResource(R.string.not_a_member),
            textEnd = stringResource(R.string.register_now),
            onClick = { loginInteractions.onCreateClick() },
        )
    }
}
