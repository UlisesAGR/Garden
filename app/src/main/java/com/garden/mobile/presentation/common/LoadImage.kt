package com.garden.mobile.presentation.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun LoadImage(
    modifier: Modifier = Modifier,
    data: String?,
    placeholder: Int,
    error: Int,
) {
    val context = LocalContext.current
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(context)
            .data(data)
            .crossfade(true)
            .placeholder(placeholder)
            .error(error)
            .build(),
        contentScale = ContentScale.Crop,
        contentDescription = null,
    )
}
