package com.garden.mobile.domian

import androidx.compose.runtime.Stable

@Stable
data class Plant(
    val id: Int,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int,
    val imageUrl: String,
)
