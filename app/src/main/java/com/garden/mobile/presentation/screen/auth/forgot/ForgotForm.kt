package com.garden.mobile.presentation.screen.auth.forgot

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.garden.mobile.presentation.common.EmailField
import com.garden.mobile.presentation.common.TopBarSimple
import com.garden.mobile.presentation.screen.auth.forgot.viewmodel.ForgotState
import com.garden.mobile.presentation.screen.auth.forgot.viewmodel.ForgotViewModel

@Composable
fun ForgotForm(
    viewModel: ForgotViewModel,
    state: ForgotState.Data,
    onBackClick: () -> Unit,
) = with(state) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding)),
        verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_big)),
    ) {
        TopBarSimple(
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = { onBackClick() },
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            text = stringResource(R.string.forgot_your_password),
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall,
            text = stringResource(R.string.an_email_will_be_sent_to_recover_your_password),
        )
        EmailField(
            email,
            error = emailError,
            imeAction = ImeAction.Next,
            onTextFieldChanged = { email ->
                viewModel.onEvent(email)
            },
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space)))
        ButtonPrimary(
            text = stringResource(R.string.create),
            onClick = {
                viewModel.validateForm(email)
            },
        )
    }
}
