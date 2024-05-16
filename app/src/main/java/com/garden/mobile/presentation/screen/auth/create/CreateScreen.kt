package com.garden.mobile.presentation.screen.auth.create

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.presentation.common.ButtonPrimaryEnable
import com.garden.mobile.presentation.common.CheckboxTexButton
import com.garden.mobile.presentation.common.DividerText
import com.garden.mobile.presentation.common.EmailField
import com.garden.mobile.presentation.common.PasswordField
import com.garden.mobile.presentation.common.SocialMediaList
import com.garden.mobile.presentation.common.TopBarSimple

@Composable
fun CreateScreen(
    onBackClick: () -> Unit,
    viewModel: CreateViewModel = CreateViewModel(),
) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val confirmPassword: String by viewModel.confirmPassword.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.createEnable.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_big)),
    ) {
        TopBarSimple(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = { onBackClick() },
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_small)))
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
            imeAction = ImeAction.Next,
            onTextFieldChanged = { viewModel.onCreateChanged(it, password, confirmPassword) },
        )
        PasswordField(
            text = stringResource(R.string.password),
            imeAction = ImeAction.Next,
            password,
            onTextFieldChanged = { viewModel.onCreateChanged(email, it, confirmPassword) },
            supportingText = stringResource(R.string._6_character_password),
        )
        PasswordField(
            text = stringResource(R.string.password),
            imeAction = ImeAction.Done,
            password,
            onTextFieldChanged = { viewModel.onCreateChanged(email, password, it) },
            supportingText = stringResource(R.string._6_character_password),
        )
        CheckboxTexButton(
            textStart = stringResource(R.string.i_agree),
            textEnd = stringResource(R.string.terms_and_conditions),
        )
        ButtonPrimaryEnable(
            text = stringResource(R.string.create),
            enable = loginEnable,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCreateScreen() {
    CreateScreen(onBackClick = {})
}
