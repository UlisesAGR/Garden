package com.garden.mobile.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.garden.mobile.data.local.entity.PlantGardenEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GardenDao {
    @Query("SELECT * FROM garden")
    fun getGarden(): Flow<List<PlantGardenEntity>>

    @Query("SELECT * FROM garden WHERE id=:plantId")
    suspend fun getPlantFromGarden(plantId: Int): PlantGardenEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToGarden(plant: PlantGardenEntity)

    @Delete
    suspend fun deleteToGarden(plant: PlantGardenEntity)
}
