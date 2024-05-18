package com.garden.mobile.presentation.screen.content.garden.viewmodel

import com.garden.mobile.domian.model.Plant

sealed class GardenState {
    internal data class Loading(
        val isLoading: Boolean,
    ) : GardenState()

    internal data class Data(
        val plants: List<Plant>,
    ) : GardenState()

    internal data class Error(
        val message: String,
    ) : GardenState()
}
