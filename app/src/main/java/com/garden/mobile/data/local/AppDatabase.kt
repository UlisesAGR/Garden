package com.garden.mobile.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.garden.mobile.data.local.dao.GardenDao
import com.garden.mobile.data.local.dao.PlantsDao
import com.garden.mobile.data.local.entity.PlantEntity
import com.garden.mobile.data.local.entity.PlantGardenEntity

@Database(
    entities = [
        PlantGardenEntity::class,
        PlantEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gardenDao(): GardenDao
    abstract fun plantsDao(): PlantsDao
}
