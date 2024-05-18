package com.garden.mobile.ui.utils

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.garden.mobile.R
import com.garden.mobile.domian.model.Plant

fun getPlants() = (1..10).map {
    Plant(
        id = it,
        name = "Plant $it",
        description = "Mangoes are juicy stone fruit (drupe) from numerous species of tropical trees belonging to the flowering plant genus Mangifera, cultivated mostly for their edible fruit. The majority of these species are found in nature as wild mangoes. The genus belongs to the cashew family Anacardiaceae. Mangoes are native to South Asia, from where the 'common mango' or 'Indian mango', Mangifera indica, has been distributed worldwide to become one of the most widely cultivated fruits in the tropics. Other Mangifera species (e.g. horse mango, Mangifera foetida) are grown on a more localized basis. It is the national fruit of India, Pakistan, and the Philippines, and the national tree of Bangladesh.",
        type = "Sol",
        plantDate = "May 7, 2024",
        growZoneNumber = 1,
        wateringInterval = 1,
        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/67/Mangos_criollos_y_pera.JPG",
    )
}

fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

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
