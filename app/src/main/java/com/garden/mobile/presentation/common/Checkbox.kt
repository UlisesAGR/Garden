package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.garden.mobile.R
import com.garden.mobile.domian.model.ValidationResults

@Composable
fun CheckboxTexButton(
    textStart: String,
    textEnd: String,
    error: ValidationResults,
    onTextClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_checkbox)),
        ) {
            Checkbox(
                checked = error.status,
                onCheckedChange = onCheckedChange,
            )
            ButtonTextColor(
                textStart = textStart,
                textEnd = textEnd,
                onClick = { onTextClick() },
            )
        }
    }
}
