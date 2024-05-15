package com.garden.mobile.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.garden.mobile.presentation.navigation.AuthRoute
import com.garden.mobile.presentation.navigation.DetailRoute
import com.garden.mobile.presentation.navigation.Graph
import com.garden.mobile.presentation.navigation.MainRoute
import com.garden.mobile.presentation.screen.content.detail.DetailScreen
import com.garden.mobile.presentation.screen.content.garden.GardenScreen
import com.garden.mobile.presentation.screen.content.list.ListScreen

@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    mainNavController: NavHostController,
) {
    NavHost(
        navController = mainNavController,
        route = Graph.MAIN_GRAPH,
        startDestination = MainRoute.Garden.route,
    ) {
        composable(route = MainRoute.Garden.route) {
            GardenScreen(
                onLogoutClick = {
                    rootNavController.navigate(AuthRoute.Login.route)
                }
            )
        }
        composable(route = MainRoute.List.route) {
            ListScreen(
                onPlantClick = { plant ->
                    DetailRoute.Detail.createRoute(plantId = plant.id)
                }
            )
        }
        composable(
            route = DetailRoute.Detail.route,
            arguments = DetailRoute.Detail.navArguments,
        ) {
            DetailScreen(
                onBackClick = {
                    mainNavController.navigateUp()
                }
            )
        }
    }
}
