package com.garden.mobile.domian.repository

import com.garden.mobile.domian.model.Plant
import kotlinx.coroutines.flow.Flow

interface GardenRepository {
    suspend fun getGarden(): Flow<List<Plant>>
    suspend fun getPlantFromGarden(plantId: Int): Flow<Plant?>
    suspend fun addToGarden(plant: Plant): Flow<Unit>
    suspend fun deleteToGarden(plant: Plant): Flow<Unit>
}
