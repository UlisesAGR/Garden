package com.garden.mobile.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.garden.mobile.presentation.navigation.Graph
import com.garden.mobile.presentation.screen.content.main.MainScreen

@Composable
fun RootNavGraph(rootNavController: NavHostController = rememberNavController()) {
    NavHost(
        navController = rootNavController,
        route = Graph.ROOT_GRAPH,
        startDestination = Graph.AUTH_GRAPH,
    ) {
        authNavGraph(rootNavController)
        composable(route = Graph.MAIN_GRAPH) {
            MainScreen(rootNavController)
        }
    }
}
