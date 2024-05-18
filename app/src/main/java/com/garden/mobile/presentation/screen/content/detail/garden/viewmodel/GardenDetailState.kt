package com.garden.mobile.presentation.screen.content.detail.garden.viewmodel

import com.garden.mobile.domian.model.Plant

sealed class GardenDetailState {
    internal data class Loading(
        val isLoading: Boolean,
    ) : GardenDetailState()

    internal data class Data(
        val plant: Plant,
    ) : GardenDetailState()

    internal data class Error(
        val message: String,
    ) : GardenDetailState()
}
