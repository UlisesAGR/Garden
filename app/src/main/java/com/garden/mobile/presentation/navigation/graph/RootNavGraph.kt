package com.garden.mobile.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.garden.mobile.presentation.navigation.Graph

@Composable
fun RootNavGraph(rootNavController: NavHostController = rememberNavController()) {
    NavHost(
        navController = rootNavController,
        route = Graph.ROOT_GRAPH,
        startDestination = Graph.AUTH_GRAPH,
    ) {
        authNavGraph(rootNavController)
        composable(route = Graph.HOME_GRAPH) {
            MainNavGraph(rootNavController)
        }
    }
}
