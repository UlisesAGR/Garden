package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.Role
import com.garden.mobile.R

@Composable
fun CheckboxTexButton(
    textStart: String,
    textEnd: String,
    onClick: () -> Unit,
) {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox,
            )
            .padding(vertical = dimensionResource(id = R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_small)),
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null,
        )
        ButtonTextColor(
            textStart = textStart,
            textEnd = textEnd,
            onClick = { onClick() },
        )
    }
}
