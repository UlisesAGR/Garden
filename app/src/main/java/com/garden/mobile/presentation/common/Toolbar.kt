package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R

@Composable
fun TopBarSimple(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    Row(modifier = modifier.fillMaxWidth()) {
        SmallFloatingActionButton(
            onClick = { onClick() },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    onBackClick: () -> Unit,
    onIconClick: () -> Unit,
) {
    Row(modifier = modifier.fillMaxWidth()) {
        SmallFloatingActionButton(
            onClick = { onBackClick() },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
            )
        }
        Text(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            text = title,
        )
        SmallFloatingActionButton(
            onClick = { onIconClick() },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun PreviewTopBar() {
    TopBar(
        title = stringResource(id = R.string.example),
        icon = Icons.Default.AccountCircle,
        onBackClick = {},
        onIconClick = {},
    )
}

@Preview
@Composable
private fun PreviewTopBarSimple() {
    TopBarSimple(
        icon = Icons.AutoMirrored.Filled.ArrowBack,
        onClick = {},
    )
}
