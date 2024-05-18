package com.garden.mobile.presentation.screen.content.detail.garden.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.mobile.data.utils.parseException
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.domian.provider.ResourceProvider
import com.garden.mobile.domian.usecase.garden.DeleteToGardenUseCase
import com.garden.mobile.domian.usecase.garden.GetPlantFromGardenUseCase
import com.garden.mobile.presentation.navigation.DetailRoute.Companion.PLANT_ID_GARDEN_KEY
import com.garden.mobile.ui.utils.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GardenDetailViewModel @Inject constructor(
    private val getPlantFromGardenUseCase: GetPlantFromGardenUseCase,
    private val deleteToGardenUseCase: DeleteToGardenUseCase,
    private val resourceProvider: ResourceProvider,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val characterId: Int = savedStateHandle.get<Int>(PLANT_ID_GARDEN_KEY) ?: 0

    private val _state = MutableLiveData<GardenDetailState>()
    val state: LiveData<GardenDetailState> = _state

    private val _components = MutableLiveData<UIComponent>()
    val components: LiveData<UIComponent> = _components

    private lateinit var currentPlant: Plant

    init {
        getPlant()
    }

    private fun getPlant() =
        viewModelScope.launch {
            getPlantFromGardenUseCase.invoke(characterId)
                .catch { exception ->
                    _state.value = GardenDetailState.Loading(isLoading = false)
                    _state.value = GardenDetailState.Error(
                        message = resourceProvider.parseError(exception.parseException().error)
                    )
                }
                .collect { response ->
                    response?.let { plant ->
                        _state.value = GardenDetailState.Loading(isLoading = false)
                        _state.value = GardenDetailState.Data(plant = plant)
                        currentPlant = plant
                    }
                }
        }

    fun deletePlantToGarden() =
        viewModelScope.launch {
            deleteToGardenUseCase.invoke(currentPlant)
                .catch { exception ->
                    _state.value = GardenDetailState.Error(
                        message = resourceProvider.parseError(exception.parseException().error)
                    )
                }
                .collect { response ->
                    response.let {
                        _components.value = UIComponent.Toast(
                            message = resourceProvider.deletePlantToGardenLabel(),
                        )
                    }
                }
        }
}
