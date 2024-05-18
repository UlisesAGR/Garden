package com.garden.mobile.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class PlantEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "plantDate") val plantDate: String,
    @ColumnInfo(name = "growZoneNumber") val growZoneNumber: Int,
    @ColumnInfo(name = "wateringInterval") val wateringInterval: Int,
    @ColumnInfo(name = "imageUrl") val imageUrl: String,
)
