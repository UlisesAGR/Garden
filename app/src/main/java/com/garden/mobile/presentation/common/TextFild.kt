package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.garden.mobile.R

@Composable
fun Field(
    text: String,
    label: String,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    onTextFieldChanged: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { onTextFieldChanged(it) },
        singleLine = true,
        maxLines = 1,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
    )
}

@Composable
fun EmailField(
    email: String,
    imeAction: ImeAction,
    onTextFieldChanged: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        singleLine = true,
        maxLines = 1,
        label = { Text(stringResource(R.string.email)) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = imeAction,
        ),
    )
}

@Composable
fun PasswordField(
    text: String,
    imeAction: ImeAction,
    password: String,
    onTextFieldChanged: (String) -> Unit,
    supportingText: String,
) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        singleLine = true,
        maxLines = 1,
        label = { Text(text) },
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction,
        ),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                Icon(
                    imageVector = if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = null,
                )
            }
        },
        supportingText = { Text(supportingText) },
    )
}
