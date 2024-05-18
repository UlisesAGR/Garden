package com.garden.mobile.data.repository

import com.garden.mobile.data.source.GardenDataSource
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.domian.repository.GardenRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GardenRepositoryImpl @Inject constructor(
    private val gardenDataSource: GardenDataSource,
    private val dispatcher: CoroutineDispatcher,
) : GardenRepository {
    override suspend fun getGarden(): Flow<List<Plant>> =
        gardenDataSource.getGarden()
            .flowOn(dispatcher)

    override suspend fun getPlantFromGarden(plantId: Int) =
        flow {
            emit(gardenDataSource.getPlantFromGarden(plantId))
        }.flowOn(dispatcher)

    override suspend fun addToGarden(plant: Plant): Flow<Unit> =
        flow {
            emit(gardenDataSource.addToGarden(plant))
        }.flowOn(dispatcher)

    override suspend fun deleteToGarden(plant: Plant): Flow<Unit> =
        flow {
            emit(gardenDataSource.deleteToGarden(plant))
        }.flowOn(dispatcher)
}
