package com.garden.mobile.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object Graph {
    const val ROOT_GRAPH = "rootGraph"
    const val AUTH_GRAPH = "authGraph"
    const val HOME_GRAPH = "homeGraph"
}

sealed class AuthRoute(val route: String) {
    data object Welcome : AuthRoute(route = "welcome")
    data object Login : AuthRoute(route = "login")
    data object Create : AuthRoute(route = "create")
    data object Forgot : AuthRoute(route = "forgot")
}

sealed class MainRoute(val route: String) {
    data object Home : MainRoute(route = "garden")
}

sealed class DetailRoute(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList(),
) {
    data object GardenDetail : DetailRoute(
        route = "detailGarden/{plantId_garden}",
        navArguments = listOf(navArgument("plantId_garden") { type = NavType.IntType })
    ) {
        fun createRoute(plantId: Int) = "detailGarden/${plantId}"
    }

    data object PlantDetail : DetailRoute(
        route = "detailPlant/{plantId_plants}",
        navArguments = listOf(navArgument("plantId_plants") { type = NavType.IntType })
    ) {
        fun createRoute(plantId: Int) = "detailPlant/${plantId}"
    }

    companion object {
        const val PLANT_ID_GARDEN_KEY = "plantId_garden"
        const val PLANT_ID_PLANTS_KEY = "plantId_plants"
    }
}
