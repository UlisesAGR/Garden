package com.garden.mobile.presentation.screen.auth.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.garden.mobile.R
import com.garden.mobile.presentation.common.ButtonPrimaryEnable
import com.garden.mobile.presentation.common.CheckboxTexButton
import com.garden.mobile.presentation.common.DividerText
import com.garden.mobile.presentation.common.EmailField
import com.garden.mobile.presentation.common.Field
import com.garden.mobile.presentation.common.PasswordField
import com.garden.mobile.presentation.common.SocialMediaList
import com.garden.mobile.presentation.common.TopBarSimple
import com.garden.mobile.presentation.navigation.interections.CreateInteractions
import com.garden.mobile.presentation.navigation.interections.SocialMediaInteractions
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateState
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateViewModel

@Composable
fun CreateForm(
    viewModel: CreateViewModel,
    state: CreateState.Data,
    createInteractions: CreateInteractions,
    socialMediaInteractions: SocialMediaInteractions,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding)),
        verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_big)),
    ) {
        TopBarSimple(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = { createInteractions.onBackClick() },
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            text = stringResource(R.string.create_your_account),
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall,
            text = stringResource(R.string.welcome_back_a_hava_a_nice_day),
        )
        SocialMediaList(
            modifier = Modifier.fillMaxWidth(),
            onFacebook = { socialMediaInteractions.onFacebookClick() },
            onGoogle = { socialMediaInteractions.onGmailClick() },
        )
        DividerText(text = stringResource(R.string.or_continue_with))
        Field(
            text = state.name,
            label = stringResource(R.string.name),
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            onTextFieldChanged = { name ->
                viewModel.onCreateChanged(name, state.email, state.password, state.confirmPassword)
            },
        )
        EmailField(
            state.email,
            imeAction = ImeAction.Next,
            onTextFieldChanged = { email ->
                viewModel.onCreateChanged(state.name, email, state.password, state.confirmPassword)
            },
        )
        PasswordField(
            text = stringResource(R.string.password),
            imeAction = ImeAction.Next,
            state.password,
            onTextFieldChanged = { password ->
                viewModel.onCreateChanged(state.name, state.email, password, state.confirmPassword)
            },
            supportingText = stringResource(R.string._6_character_password),
        )
        PasswordField(
            text = stringResource(R.string.confirm_password),
            imeAction = ImeAction.Done,
            state.confirmPassword,
            onTextFieldChanged = { confirmPassword ->
                viewModel.onCreateChanged(state.name, state.email, state.password, confirmPassword)
            },
            supportingText = stringResource(R.string._6_character_password),
        )
        CheckboxTexButton(
            textStart = stringResource(R.string.i_agree),
            textEnd = stringResource(R.string.terms_and_conditions),
            onClick = { createInteractions.onTermsClick() },
        )
        ButtonPrimaryEnable(
            text = stringResource(R.string.create),
            enable = state.isLoginEnable,
            onClick = { createInteractions.onCreateClick() },
        )
    }
}
