package com.garden.mobile.presentation.screen.content.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.garden.mobile.domian.model.Plant
import com.garden.mobile.presentation.screen.content.garden.GardenScreen
import com.garden.mobile.presentation.screen.content.plants.PlantsScreen
import com.garden.mobile.presentation.navigation.interections.TabInteractions
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePageScreen(
    innerPadding: PaddingValues,
    onGardenClick: (Plant) -> Unit,
    onPlantClick: (Plant) -> Unit,
) {
    val tabItems = listOf(
        TabInteractions.Garden,
        TabInteractions.Plants,
    )
    val pagerState = rememberPagerState(pageCount = { tabItems.size })
    Column(modifier = Modifier.padding(innerPadding)) {
        val coroutineScope = rememberCoroutineScope()
        TabRow(
            containerColor = MaterialTheme.colorScheme.background,
            selectedTabIndex = pagerState.currentPage,
        ) {
            tabItems.forEachIndexed { index, page ->
                val title = stringResource(id = page.titleResId)
                Tab(
                    unselectedContentColor = MaterialTheme.colorScheme.primary,
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = { Text(text = title) },
                    icon = {
                        Icon(
                            painter = painterResource(id = page.drawableResId),
                            contentDescription = null,
                        )
                    },
                )
            }
        }
        HorizontalPager(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            state = pagerState,
            verticalAlignment = Alignment.Top,
        ) { index ->
            when (tabItems[index]) {
                TabInteractions.Garden -> GardenScreen(
                    onAddPlantClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(page = 2)
                        }
                    },
                    onListClick = { plant ->
                        onGardenClick(plant)
                    },
                )

                TabInteractions.Plants -> PlantsScreen(
                    onListClick = { plant ->
                        onPlantClick(plant)
                    },
                )
            }
        }
    }
}
