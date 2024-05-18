package com.garden.mobile.domian.provider

import com.garden.mobile.data.utils.DataError

interface ResourceProvider {
    fun errorRedLabel(): String
    fun errorTimeoutLabel(): String
    fun errorHttpLabel(): String
    fun errorGenericLabel(): String
    fun parseError(network: DataError.Errors): String
    fun deletePlantToGardenLabel(): String
    fun addPlantToGardenLabel(): String
}
