package com.garden.mobile.presentation.screen.content.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.garden.mobile.presentation.navigation.graph.MainNavGraph

@Composable
fun MainScreen(
    rootNavController: NavHostController,
    mainNavController: NavHostController = rememberNavController(),
) {
    MainNavGraph(rootNavController, mainNavController)
}

@Preview(showBackground = true)
@Composable
private fun PreviewNavigation() {
    MainScreen(rememberNavController())
}
