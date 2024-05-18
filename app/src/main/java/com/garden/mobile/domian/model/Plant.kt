package com.garden.mobile.domian.model

import androidx.compose.runtime.Stable
import com.garden.mobile.data.local.entity.PlantEntity
import com.garden.mobile.data.local.entity.PlantGardenEntity

@Stable
data class Plant(
    val id: Int,
    val name: String,
    val type: String,
    val description: String,
    val plantDate: String,
    val growZoneNumber: Int,
    val wateringInterval: Int,
    val imageUrl: String,
)

fun Plant.toGardenEntity() =
    PlantGardenEntity(id, name, type, description, plantDate, growZoneNumber, wateringInterval, imageUrl)

fun Plant.toEntity() =
    PlantEntity(id, name, type, description, plantDate, growZoneNumber, wateringInterval, imageUrl)

fun PlantGardenEntity.toDomain() =
    Plant(id, name, type, description, plantDate, growZoneNumber, wateringInterval, imageUrl)

fun PlantEntity.toDomain() =
    Plant(id, name, type, description, plantDate, growZoneNumber, wateringInterval, imageUrl)
