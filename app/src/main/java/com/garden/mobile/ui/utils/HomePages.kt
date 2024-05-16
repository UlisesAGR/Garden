package com.garden.mobile.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.garden.mobile.R

sealed class HomePages(
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int,
) {
    data object Garden :
        HomePages(titleResId = R.string.my_garden, drawableResId = R.drawable.ic_garden)

    data object Plants :
        HomePages(titleResId = R.string.plant_list, drawableResId = R.drawable.ic_plant)
}