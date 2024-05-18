package com.garden.mobile.presentation.screen.content.plants.viewmodel

import com.garden.mobile.domian.model.Plant

sealed class PlantsState {
    internal data class Loading(
        val isLoading: Boolean,
    ) : PlantsState()

    internal data class Data(
        val plants: List<Plant>,
    ) : PlantsState()

    internal data class Error(
        val message: String,
    ) : PlantsState()
}
