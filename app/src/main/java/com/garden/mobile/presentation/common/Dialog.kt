package com.garden.mobile.presentation.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.garden.mobile.R

@Composable
fun Dialog(
    isShow: Boolean,
    icon: ImageVector,
    text: String,
    textConfirmation: String,
    onConfirmation: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    if (isShow) {
        AlertDialog(
            icon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                )
            },
            title = {
                Text(text = stringResource(id = R.string.message))
            },
            text = {
                Text(
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Justify,
                    text = text,
                )
            },
            onDismissRequest = {
                onDismissRequest()
            },
            confirmButton = {
                TextButton(
                    onClick = { onConfirmation() }
                ) {
                    Text(
                        style = MaterialTheme.typography.titleMedium,
                        text = textConfirmation,
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { onDismissRequest() }
                ) {
                    Text(
                        style = MaterialTheme.typography.titleMedium,
                        text = stringResource(R.string.cancel),
                    )
                }
            }
        )
    }
}
