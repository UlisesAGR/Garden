package com.garden.mobile.domian.usecase.garden

import com.garden.mobile.domian.model.Plant
import com.garden.mobile.domian.repository.GardenRepository
import javax.inject.Inject

class DeleteToGardenUseCase @Inject constructor(
    private val gardenRepository: GardenRepository,
) {
    suspend operator fun invoke(plant: Plant) = gardenRepository.deleteToGarden(plant)
}
