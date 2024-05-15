package com.garden.mobile.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.garden.mobile.presentation.navigation.AuthRoute
import com.garden.mobile.presentation.navigation.Graph
import com.garden.mobile.presentation.screen.auth.create.CreateScreen
import com.garden.mobile.presentation.screen.auth.forgot.ForgotScreen
import com.garden.mobile.presentation.screen.auth.login.LoginScreen
import com.garden.mobile.presentation.screen.auth.welcome.WelcomeScreen

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = AuthRoute.Welcome.route,
    ) {
        composable(route = AuthRoute.Welcome.route) {
            WelcomeScreen(
                onLoginClick = {
                    rootNavController.navigate(AuthRoute.Login.route)
                },
                onCreateClick = {
                    rootNavController.navigate(AuthRoute.Create.route)
                },
            )
        }
        composable(route = AuthRoute.Login.route) {
            LoginScreen(
                onBackClick = {
                    rootNavController.popBackStack()
                },
                onGardenClick = {
                    rootNavController.navigate(Graph.MAIN_GRAPH) {
                        popUpTo(AuthRoute.Login.route) { inclusive = true }
                    }
                },
                onForgotClick = {
                    rootNavController.navigate(AuthRoute.Forgot.route)
                },
                onCreateClick = {
                    rootNavController.navigate(AuthRoute.Create.route)
                },
            )
        }
        composable(route = AuthRoute.Create.route) {
            CreateScreen(
                onBackClick = {
                    rootNavController.popBackStack()
                },
            )
        }
        composable(route = AuthRoute.Forgot.route) {
            ForgotScreen(
                onBackClick = {
                    rootNavController.popBackStack()
                },
            )
        }
    }
}
