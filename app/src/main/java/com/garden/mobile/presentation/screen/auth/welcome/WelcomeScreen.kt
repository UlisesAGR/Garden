package com.garden.mobile.presentation.screen.auth.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.presentation.common.ButtonPrimary
import com.garden.mobile.presentation.common.ButtonSecondary

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,
    onCreateClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding)),
        verticalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.padding_big),
            alignment = Alignment.CenterVertically,
        ),
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.il_garden),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space)))
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            text = stringResource(R.string.see_all_your_favorite_plants),
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall,
            text = stringResource(R.string.water_your_plants_on_time_with_this_app),
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_big)))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding)),
        ) {
            ButtonPrimary(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.login),
                onClick = { onLoginClick() },
            )
            ButtonSecondary(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.create),
                onClick = { onCreateClick() },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewWelcomeScreen() {
    WelcomeScreen(onLoginClick = {}, onCreateClick = {})
}
