package com.garden.mobile.domian

import androidx.compose.runtime.Stable

@Stable
data class Plant(
    val id: Int,
    val name: String,
    val description: String,
    val plantDate: String,
    val growZoneNumber: Int,
    val wateringInterval: Int,
    val imageUrl: String,
)

fun getPlants() = (1..10).map {
    Plant(
        id = it,
        name = "Plant $it",
        description = "Plant",
        plantDate = "May 7, 2024",
        growZoneNumber = 1,
        wateringInterval = 1,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/67/Mangos_criollos_y_pera.JPG",
    )
}
