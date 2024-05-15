package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R

@Composable
fun SocialMediaList(
    modifier: Modifier = Modifier,
    onFacebook: () -> Unit,
    onGoogle: () -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            space = dimensionResource(id = R.dimen.padding_extra),
            alignment = Alignment.CenterHorizontally,
        ),
    ) {
        FloatingActionButton(
            onClick = { onFacebook() },
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = Color.White,
        ) {
            Icon(
                imageVector = Icons.Filled.Facebook,
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon)),
            )
        }
        FloatingActionButton(
            onClick = { onGoogle() },
            containerColor = MaterialTheme.colorScheme.errorContainer,
            contentColor = Color.White,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.il_google),
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.icon_small)),
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSocialMediaList() {
    SocialMediaList(onFacebook = {}, onGoogle = {})
}