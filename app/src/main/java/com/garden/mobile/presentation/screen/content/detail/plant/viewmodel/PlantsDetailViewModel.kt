package com.garden.mobile.presentation.screen.content.detail.plant.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.mobile.data.utils.parseException
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.domian.provider.ResourceProvider
import com.garden.mobile.domian.usecase.garden.AddToGardenUseCase
import com.garden.mobile.domian.usecase.plants.GetPlantUseCase
import com.garden.mobile.presentation.navigation.DetailRoute.Companion.PLANT_ID_PLANTS
import com.garden.mobile.ui.utils.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantsDetailViewModel @Inject constructor(
    private val getPlantUseCase: GetPlantUseCase,
    private val addToGardenUseCase: AddToGardenUseCase,
    private val resourceProvider: ResourceProvider,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val plantId: Int = savedStateHandle.get<Int>(PLANT_ID_PLANTS) ?: 0

    private val _state = MutableLiveData<PlantsDetailState>()
    val state: LiveData<PlantsDetailState> = _state

    private val _components = MutableLiveData<UIComponent>()
    val components: LiveData<UIComponent> = _components

    private lateinit var currentPlant: Plant

    init {
        getPlant()
    }

    private fun getPlant() =
        viewModelScope.launch {
            getPlantUseCase.invoke(plantId)
                .catch { exception ->
                    _state.value = PlantsDetailState.Loading(isLoading = false)
                    _state.value = PlantsDetailState.Error(
                        message = resourceProvider.parseError(exception.parseException().error)
                    )
                }
                .collect { response ->
                    response?.let { plantGarden ->
                        _state.value = PlantsDetailState.Loading(isLoading = false)
                        _state.value = PlantsDetailState.Data(plant = plantGarden)
                        currentPlant = plantGarden
                    }
                }
        }

    fun addPlantToGarden() =
        viewModelScope.launch {
            addToGardenUseCase.invoke(currentPlant)
                .catch { exception ->
                    _state.value = PlantsDetailState.Error(
                        message = resourceProvider.parseError(exception.parseException().error)
                    )
                }
                .collect { response ->
                    response.let {
                        _components.value = UIComponent.Toast(
                            message = resourceProvider.addPlantToGardenLabel(),
                        )
                    }
                }
        }
}
