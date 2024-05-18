package com.garden.mobile.ui.utils

sealed class UIComponent {
    internal data class Toast(
        val message: String,
    ) : UIComponent()
}
