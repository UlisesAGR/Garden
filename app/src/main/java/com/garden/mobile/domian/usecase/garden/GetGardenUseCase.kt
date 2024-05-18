package com.garden.mobile.domian.usecase.garden

import com.garden.mobile.domian.repository.GardenRepository
import javax.inject.Inject

class GetGardenUseCase @Inject constructor(
    private val gardenRepository: GardenRepository,
) {
    suspend operator fun invoke() = gardenRepository.getGarden()
}
