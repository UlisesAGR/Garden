package com.garden.mobile.domian.usecase.plants

import com.garden.mobile.domian.repository.PlantsRepository
import javax.inject.Inject

class GetPlantUseCase @Inject constructor(
    private val plantsRepository: PlantsRepository,
) {
    suspend operator fun invoke(plantId: Int) = plantsRepository.getPlant(plantId)
}
