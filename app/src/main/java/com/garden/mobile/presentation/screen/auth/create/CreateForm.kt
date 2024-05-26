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
import androidx.compose.ui.text.style.TextAlign
import com.garden.mobile.R
import com.garden.mobile.presentation.common.ButtonPrimary
import com.garden.mobile.presentation.common.CheckboxTexButton
import com.garden.mobile.presentation.common.DividerText
import com.garden.mobile.presentation.common.EmailField
import com.garden.mobile.presentation.common.PasswordField
import com.garden.mobile.presentation.common.SocialMediaList
import com.garden.mobile.presentation.common.TopBarSimple
import com.garden.mobile.presentation.navigation.interections.CreateInteractions
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateFormEvent
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateState
import com.garden.mobile.presentation.screen.auth.create.viewmodel.CreateViewModel
import com.garden.mobile.ui.utils.TERMS

@Composable
fun CreateForm(
    viewModel: CreateViewModel,
    state: CreateState,
    createInteractions: CreateInteractions,
) = with(state) {
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
            onFacebook = {},
            onGoogle = {},
        )
        DividerText(text = stringResource(R.string.or_continue_with))
        EmailField(
            email,
            error = emailError,
            imeAction = ImeAction.Next,
            onTextFieldChanged = { email ->
                viewModel.onEvent(CreateFormEvent.EmailChanged(email))
            },
        )
        PasswordField(
            password,
            error = passwordError,
            hint = stringResource(R.string.password),
            imeAction = ImeAction.Next,
            onTextFieldChanged = { password ->
                viewModel.onEvent(CreateFormEvent.PasswordChanged(password))
            },
        )
        PasswordField(
            repeatedPassword,
            error = repeatedPasswordError,
            hint = stringResource(R.string.repeated_password),
            imeAction = ImeAction.Done,
            onTextFieldChanged = { repeatedPassword ->
                viewModel.onEvent(CreateFormEvent.RepeatedPasswordChanged(repeatedPassword))
            },
        )
        CheckboxTexButton(
            textStart = stringResource(R.string.i_agree),
            textEnd = stringResource(R.string.terms_and_conditions),
            error = termsError,
            onTextClick = { createInteractions.onTermsClick(TERMS) },
            onCheckedChange = { isAccepted ->
                viewModel.onEvent(CreateFormEvent.AcceptTerms(isAccepted))
            },
        )
        ButtonPrimary(
            text = stringResource(R.string.create),
            onClick = {
                viewModel.onEvent(CreateFormEvent.ValidateForm)
            },
        )
    }
}
