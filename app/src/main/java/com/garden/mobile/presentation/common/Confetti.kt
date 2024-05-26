package com.garden.mobile.presentation.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

@Composable
fun Confetti() {
    KonfettiView(
        modifier = Modifier.fillMaxSize(),
        parties = listOf(
            Party(
                speed = 0f,
                maxSpeed = 30f,
                damping = 0.9f,
                spread = 360,
                colors = listOf(0x006E21, 0xFFFFFF, 0x004CA8),
                position = Position.Relative(0.5, 0.4),
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
            )
        ),
    )
}