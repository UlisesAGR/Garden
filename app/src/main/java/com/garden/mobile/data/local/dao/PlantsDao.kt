package com.garden.mobile.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.garden.mobile.data.local.entity.PlantEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PlantsDao {
    @Query("SELECT * FROM plants")
    fun getPlants(): Flow<List<PlantEntity>>

    @Transaction
    suspend fun insertPlants(plants: List<PlantEntity>) {
        clearPlants()
        addPlants(plants)
    }

    @Query("DELETE FROM plants")
    fun clearPlants()

    @Insert
    suspend fun addPlants(plants: List<PlantEntity>)

    @Query("SELECT * FROM plants WHERE id=:plantId")
    suspend fun getPlant(plantId: Int): PlantEntity?
}
