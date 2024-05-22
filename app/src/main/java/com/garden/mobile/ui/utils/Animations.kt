package com.garden.mobile.ui.utils

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.garden.mobile.R

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

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.shimmer() = composed {
    val transition = rememberInfiniteTransition(
        label = stringResource(R.string.shimmer_transition)
    )
    val alpha = transition.animateFloat(
        initialValue = 0.2f, targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse,
        ),
        label = stringResource(R.string.shimmer),
    ).value
    background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
}

