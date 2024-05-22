package com.garden.mobile.presentation.screen.auth.terms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R
import com.garden.mobile.presentation.common.TopBarSimple
import com.garden.mobile.presentation.common.WebViewPage
import com.garden.mobile.ui.utils.TERMS

@Composable
fun TermsScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_big)),
    ) {
        TopBarSimple(
            modifier = Modifier.padding(
                top = dimensionResource(id = R.dimen.padding),
                end = dimensionResource(id = R.dimen.padding),
                start = dimensionResource(id = R.dimen.padding),
            ),
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onClick = { onBackClick() },
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.padding)),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            text = stringResource(R.string.forgot_your_password),
        )
        Card(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding))) {
            WebViewPage(
                modifier = Modifier.fillMaxSize(),
                html = TERMS,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTermsScreen() {
    TermsScreen(onBackClick = {})
}
