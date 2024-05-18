package com.garden.mobile.presentation.screen.content.detail.plant.viewmodel

import com.garden.mobile.domian.model.Plant

sealed class PlantsDetailState {
    internal data class Loading(
        val isLoading: Boolean,
    ) : PlantsDetailState()

    internal data class Data(
        val plant: Plant,
    ) : PlantsDetailState()

    internal data class Error(
        val message: String,
    ) : PlantsDetailState()
}
