package com.garden.mobile.presentation.screen.content.garden.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garden.mobile.data.utils.parseException
import com.garden.mobile.domian.provider.ResourceProvider
import com.garden.mobile.domian.usecase.garden.GetGardenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GardenViewModel @Inject constructor(
    private val getGardenUseCase: GetGardenUseCase,
    private val resourceProvider: ResourceProvider,
) : ViewModel() {

    private val _state = MutableLiveData<GardenState>()
    val state: LiveData<GardenState> = _state

    init {
        getFavorites()
    }

    private fun getFavorites() =
        viewModelScope.launch {
            getGardenUseCase.invoke()
                .catch { exception ->
                    _state.value = GardenState.Loading(isLoading = false)
                    _state.value = GardenState.Error(
                        message = resourceProvider.parseError(exception.parseException().error)
                    )
                }
                .collect { plantsGarden ->
                    _state.value = GardenState.Loading(isLoading = false)
                    _state.value = GardenState.Data(plants = plantsGarden)
                }
        }
}
