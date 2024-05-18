package com.garden.mobile.data.repository

import com.garden.mobile.data.source.PlantsDataSource
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.domian.repository.PlantsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlantsRepositoryImpl @Inject constructor(
    private val gardenDataSource: PlantsDataSource,
    private val dispatcher: CoroutineDispatcher,
) : PlantsRepository {
    override suspend fun getPlants(): Flow<List<Plant>> =
        gardenDataSource.getPlants()
            .flowOn(dispatcher)

    override suspend fun insertPlants(plants: List<Plant>): Flow<Unit> =
        flow {
            emit(gardenDataSource.insertPlants(plants))
        }.flowOn(dispatcher)

    override suspend fun getPlant(plantId: Int): Flow<Plant?> =
        flow {
            emit(gardenDataSource.getPlant(plantId))
        }.flowOn(dispatcher)
}
