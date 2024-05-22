package com.garden.mobile.presentation.navigation.interections

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.garden.mobile.R

sealed class TabInteractions(
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int,
) {
    data object Garden :
        TabInteractions(titleResId = R.string.my_garden, drawableResId = R.drawable.ic_garden)

    data object Plants :
        TabInteractions(titleResId = R.string.plant_list, drawableResId = R.drawable.ic_plant)
}