package com.garden.mobile.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.garden.mobile.presentation.navigation.AuthRoute
import com.garden.mobile.presentation.navigation.DetailRoute
import com.garden.mobile.presentation.navigation.Graph
import com.garden.mobile.presentation.navigation.MainRoute
import com.garden.mobile.presentation.screen.content.detail.DetailScreen
import com.garden.mobile.presentation.screen.content.home.HomeScreen

@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    mainNavController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = mainNavController,
        route = Graph.HOME_GRAPH,
        startDestination = MainRoute.Home.route,
    ) {
        composable(route = MainRoute.Home.route) {
            HomeScreen(
                onLogoutClick = {
                    rootNavController.navigate(AuthRoute.Login.route) {
                        popUpTo(Graph.HOME_GRAPH) { inclusive = true }
                    }
                },
                onPlantClick = { plant ->
                    mainNavController.navigate(DetailRoute.Detail.createRoute(plant.id))
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
