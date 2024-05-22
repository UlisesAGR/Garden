package com.garden.mobile.presentation.common

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewPage(
    modifier: Modifier = Modifier,
    html: String,
) {
    val mimeType = "text/html; charset=utf-8"
    val encoding = "UTF-8"
    AndroidView(
        modifier = modifier,
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )
                webViewClient = WebViewClient()
                loadDataWithBaseURL(null, html, mimeType, encoding, null)
            }
        },
        update = { webView ->
            webView.loadDataWithBaseURL(null, html, mimeType, encoding, null)
        },
    )
}
