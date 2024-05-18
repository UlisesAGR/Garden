package com.garden.mobile.presentation.screen.content.plants.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.mobile.data.utils.parseException
import com.garden.mobile.domian.provider.ResourceProvider
import com.garden.mobile.domian.usecase.plants.GetPlantsUseCase
import com.garden.mobile.domian.usecase.plants.InsertPlantsUseCase
import com.garden.mobile.ui.utils.getPlants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantsViewModel @Inject constructor(
    private val insertPlantsUseCase: InsertPlantsUseCase,
    private val getPlantsUseCase: GetPlantsUseCase,
    private val resourceProvider: ResourceProvider,
) : ViewModel() {

    private val _state = MutableLiveData<PlantsState>()
    val state: LiveData<PlantsState> = _state

    init {
        insertPlants()
    }

    private fun insertPlants() =
        viewModelScope.launch {
            insertPlantsUseCase.invoke(getPlants())
                .catch { exception ->
                    _state.value = PlantsState.Loading(isLoading = false)
                    _state.value = PlantsState.Error(
                        message = resourceProvider.parseError(exception.parseException().error)
                    )
                }
                .collect {
                    getPlats()
                }
        }

    private fun getPlats() =
        viewModelScope.launch {
            getPlantsUseCase.invoke()
                .catch { exception ->
                    _state.value = PlantsState.Loading(isLoading = false)
                    _state.value = PlantsState.Error(
                        message = resourceProvider.parseError(exception.parseException().error)
                    )
                }
                .collect { plantsGarden ->
                    _state.value = PlantsState.Loading(isLoading = false)
                    _state.value = PlantsState.Data(plants = plantsGarden)
                }
        }
}
