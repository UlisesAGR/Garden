package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.garden.mobile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    isShow: Boolean,
    icon: ImageVector,
    text: String?,
    onButtonClick: () -> Unit,
) {
    if (isShow) {
        ModalBottomSheet(onDismissRequest = { onButtonClick() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = dimensionResource(id = R.dimen.padding),
                    alignment = Alignment.CenterVertically,
                )
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    text = stringResource(R.string.message),
                )
                if (!text.isNullOrBlank()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium,
                        text = text,
                    )
                }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                ButtonPrimary(text = stringResource(R.string.accept)) {
                    onButtonClick()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomSheetPreview() {
    BottomSheet(
        isShow = true,
        icon = Icons.AutoMirrored.Filled.Message,
        text = stringResource(id = R.string.example),
        onButtonClick = {},
    )
}
