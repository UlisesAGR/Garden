package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.garden.mobile.R

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        onClick = { onClick() },
    ) {
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = text,
        )
    }
}

@Composable
fun ButtonPrimaryEnable(
    modifier: Modifier = Modifier,
    text: String,
    enable: Boolean,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        onClick = { onClick() },
        enabled = enable,
    ) {
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = text,
        )
    }
}

@Composable
fun ButtonSecondary(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        onClick = { onClick() },
    ) {
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = text,
        )
    }
}

@Composable
fun ButtonText(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = { onClick() },
    ) {
        Text(
            style = MaterialTheme.typography.labelSmall,
            text = text,
        )
    }
}

@Composable
fun ButtonTextColor(
    modifier: Modifier = Modifier,
    textStart: String,
    textEnd: String,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = { onClick() },
    ) {
        Text(
            style = MaterialTheme.typography.labelSmall,
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append(textStart)
                }
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append(textEnd)
                }
            },
        )
    }
}

@Preview
@Composable
private fun PreviewButtonPrimary() {
    ButtonPrimary(modifier = Modifier, text = stringResource(R.string.example), onClick = {})
}

@Preview
@Composable
private fun PreviewButtonSecondary() {
    ButtonSecondary(modifier = Modifier, text = stringResource(R.string.example), onClick = {})
}

@Preview
@Composable
private fun PreviewButtonText() {
    ButtonText(modifier = Modifier, text = stringResource(R.string.example), onClick = {})
}

@Preview
@Composable
private fun PreviewButtonTextColor() {
    ButtonTextColor(
        modifier = Modifier,
        textStart = stringResource(R.string.example),
        textEnd = stringResource(R.string.example),
        onClick = {},
    )
}
