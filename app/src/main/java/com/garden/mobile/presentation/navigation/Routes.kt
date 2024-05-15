package com.garden.mobile.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

object Graph {
    const val ROOT_GRAPH = "rootGraph"
    const val AUTH_GRAPH = "authGraph"
    const val MAIN_GRAPH = "mainGraph"
}

sealed class AuthRoute(val route: String) {
    data object Welcome : AuthRoute(route = "welcome")
    data object Login : AuthRoute(route = "login")
    data object Create : AuthRoute(route = "create")
    data object Forgot : AuthRoute(route = "forgot")
}

sealed class MainRoute(val route: String) {
    data object Garden : MainRoute(route = "garden")
    data object Plants : MainRoute(route = "plants")
}

sealed class DetailRoute(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList(),
) {
    data object Detail : DetailRoute(
        route = "detail/{plantId}",
        navArguments = listOf(navArgument("plantId") { type = NavType.IntType })
    ) {
        fun createRoute(plantId: Int) = "detail/${plantId}"
    }

    companion object {
        const val PLANT_ID_KEY = "plantId"
    }
}
