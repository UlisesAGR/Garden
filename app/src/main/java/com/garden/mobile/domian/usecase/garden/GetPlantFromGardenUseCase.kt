package com.garden.mobile.domian.usecase.garden

import com.garden.mobile.domian.repository.GardenRepository
import javax.inject.Inject

class GetPlantFromGardenUseCase @Inject constructor(
    private val gardenRepository: GardenRepository,
) {
    suspend operator fun invoke(plantId: Int) =
        gardenRepository.getPlantFromGarden(plantId)
}
