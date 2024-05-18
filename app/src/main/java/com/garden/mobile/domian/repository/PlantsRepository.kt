package com.garden.mobile.domian.repository

import com.garden.mobile.domian.model.Plant
import kotlinx.coroutines.flow.Flow

interface PlantsRepository {
    suspend fun getPlants(): Flow<List<Plant>>
    suspend fun insertPlants(plants: List<Plant>): Flow<Unit>
    suspend fun getPlant(plantId: Int): Flow<Plant?>
}
