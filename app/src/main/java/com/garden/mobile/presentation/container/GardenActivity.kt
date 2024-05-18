package com.garden.mobile.presentation.container

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.garden.mobile.presentation.navigation.graph.RootNavGraph
import com.garden.mobile.ui.theme.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GardenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Screen {
                RootNavGraph()
            }
        }
    }
}
