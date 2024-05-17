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
import com.garden.mobile.ui.utils.enterSlideIn
import com.garden.mobile.ui.utils.exitSlideOut
import com.garden.mobile.ui.utils.popEnterSlideIn
import com.garden.mobile.ui.utils.popExitSlideOut

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = AuthRoute.Welcome.route,
    ) {
        composable(
            route = AuthRoute.Welcome.route,
            exitTransition = { exitSlideOut() },
            popEnterTransition = { popEnterSlideIn() },
        ) {
            WelcomeScreen(
                onLoginClick = {
                    rootNavController.navigate(AuthRoute.Login.route) {
                        popUpTo(AuthRoute.Welcome.route) { inclusive = true }
                    }
                },
                onCreateClick = {
                    rootNavController.navigate(AuthRoute.Create.route)
                },
            )
        }
        composable(route = AuthRoute.Login.route) {
            LoginScreen(
                onGardenClick = {
                    rootNavController.navigate(Graph.HOME_GRAPH) {
                        popUpTo(Graph.AUTH_GRAPH) { inclusive = true }
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
        composable(
            route = AuthRoute.Create.route,
            enterTransition = { enterSlideIn() },
            popExitTransition = { popExitSlideOut() }
        ) {
            CreateScreen(
                onBackClick = {
                    rootNavController.popBackStack()
                },
            )
        }
        composable(
            route = AuthRoute.Forgot.route,
            enterTransition = { enterSlideIn() },
            popExitTransition = { popExitSlideOut() }
        ) {
            ForgotScreen(
                onBackClick = {
                    rootNavController.popBackStack()
                },
            )
        }
    }
}
