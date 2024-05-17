package com.garden.mobile.presentation.screen.auth.forgot

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
import com.garden.mobile.presentation.common.EmailField
import com.garden.mobile.presentation.common.TopBarSimple

@Composable
fun ForgotScreen(
    onBackClick: () -> Unit,
    viewModel: ForgotViewModel = ForgotViewModel(),
) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val forgotEnable: Boolean by viewModel.forgotEnable.observeAsState(initial = false)

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
            imeAction = ImeAction.Done,
            onTextFieldChanged = { viewModel.onForgotChanged(it) },
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_small)))
        ButtonPrimaryEnable(
            text = stringResource(R.string.retrieve),
            enable = forgotEnable,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewForgotScreen() {
    ForgotScreen(onBackClick = {})
}
