package com.garden.mobile.ui.utils

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

private const val time = 500

fun exitSlideOut() =
    slideOutHorizontally(
        targetOffsetX = { -time },
        animationSpec = tween(
            durationMillis = time,
            easing = FastOutSlowInEasing,
        )
    ) + fadeOut(animationSpec = tween(time))

fun popEnterSlideIn() =
    slideInHorizontally(
        initialOffsetX = { -time },
        animationSpec = tween(
            durationMillis = time,
            easing = FastOutSlowInEasing,
        )
    ) + fadeIn(animationSpec = tween(time))

fun enterSlideIn() =
    slideInHorizontally(
        initialOffsetX = { time },
        animationSpec = tween(
            durationMillis = time,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(animationSpec = tween(time))

fun popExitSlideOut() =
    slideOutHorizontally(
        targetOffsetX = { time },
        animationSpec = tween(
            durationMillis = time,
            easing = FastOutSlowInEasing,
        )
    ) + fadeOut(animationSpec = tween(time))
