package com.garden.mobile.data.source

import com.garden.mobile.data.local.dao.GardenDao
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.domian.model.toDomain
import com.garden.mobile.domian.model.toGardenEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GardenDataSource @Inject constructor(
    private val gardenDao: GardenDao,
) {
    fun getGarden(): Flow<List<Plant>> =
        gardenDao.getGarden().map { list ->
            list.map { plant ->
                plant.toDomain()
            }
        }

    suspend fun getPlantFromGarden(plantId: Int): Plant? =
        gardenDao.getPlantFromGarden(plantId)?.toDomain()

    suspend fun addToGarden(plant: Plant): Unit =
        gardenDao.addToGarden(plant.toGardenEntity())

    suspend fun deleteToGarden(plant: Plant): Unit =
        gardenDao.deleteToGarden(plant.toGardenEntity())
}
