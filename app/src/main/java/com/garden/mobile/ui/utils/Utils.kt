package com.garden.mobile.ui.utils

import com.garden.mobile.domian.Plant

fun getPlant() = Plant(
    id = 1,
    name = "Plant",
    description = "Mangoes are juicy stone fruit (drupe) from numerous species of tropical trees belonging to the flowering plant genus Mangifera, cultivated mostly for their edible fruit. The majority of these species are found in nature as wild mangoes. The genus belongs to the cashew family Anacardiaceae. Mangoes are native to South Asia, from where the 'common mango' or 'Indian mango', Mangifera indica, has been distributed worldwide to become one of the most widely cultivated fruits in the tropics. Other Mangifera species (e.g. horse mango, Mangifera foetida) are grown on a more localized basis. It is the national fruit of India, Pakistan, and the Philippines, and the national tree of Bangladesh.",
    type = "Sol",
    plantDate = "May 7, 2024",
    growZoneNumber = 1,
    wateringInterval = 1,
    imageUrl = "https://upload.wikimedia.org/wikipedia/commons/6/67/Mangos_criollos_y_pera.JPG",
)

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
