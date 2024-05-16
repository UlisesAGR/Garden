package com.garden.mobile.presentation.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
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
                Text(text = text)
            },
            onDismissRequest = {
                onDismissRequest()
            },
            confirmButton = {
                TextButton(
                    onClick = { onConfirmation() }
                ) {
                    Text(textConfirmation)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { onDismissRequest() }
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        )
    }
}
