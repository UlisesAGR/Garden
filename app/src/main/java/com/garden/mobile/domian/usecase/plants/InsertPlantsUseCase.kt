package com.garden.mobile.domian.usecase.plants

import com.garden.mobile.domian.model.Plant
import com.garden.mobile.domian.repository.PlantsRepository
import javax.inject.Inject

class InsertPlantsUseCase @Inject constructor(
    private val plantsRepository: PlantsRepository,
) {
    suspend operator fun invoke(plants: List<Plant>) =
        plantsRepository.insertPlants(plants)
}
