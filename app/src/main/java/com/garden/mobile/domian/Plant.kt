package com.garden.mobile.domian

import androidx.compose.runtime.Stable

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
