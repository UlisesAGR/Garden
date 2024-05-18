package com.garden.mobile.data.source

import com.garden.mobile.data.local.dao.PlantsDao
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.domian.model.toDomain
import com.garden.mobile.domian.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlantsDataSource @Inject constructor(
    private val plantsDao: PlantsDao,
) {
    fun getPlants(): Flow<List<Plant>> =
        plantsDao.getPlants().map { list ->
            list.map { plant ->
                plant.toDomain()
            }
        }

    suspend fun insertPlants(plants: List<Plant>): Unit =
        plantsDao.insertPlants(
            plants.map { list ->
                list.toEntity()
            }
        )

    suspend fun getPlant(plantId: Int): Plant? =
        plantsDao.getPlant(plantId)?.toDomain()
}
