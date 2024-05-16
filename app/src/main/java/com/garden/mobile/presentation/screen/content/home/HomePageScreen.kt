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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.garden.mobile.presentation.screen.content.garden.GardenScreen
import com.garden.mobile.presentation.screen.content.plants.PlantsScreen
import com.garden.mobile.ui.utils.HomePages

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePageScreen(innerPadding: PaddingValues) {
    val tabItems = listOf(
        HomePages.Garden,
        HomePages.Plants,
    )
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState(pageCount = { tabItems.size })
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(modifier = Modifier.padding(innerPadding)) {
        TabRow(
            containerColor = MaterialTheme.colorScheme.background,
            selectedTabIndex = selectedTabIndex,
        ) {
            tabItems.forEachIndexed { index, page ->
                val title = stringResource(id = page.titleResId)
                Tab(
                    unselectedContentColor = MaterialTheme.colorScheme.primary,
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = title) },
                    icon = {
                        Icon(
                            painter = painterResource(id = page.drawableResId),
                            contentDescription = title,
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
                HomePages.Garden -> GardenScreen()
                HomePages.Plants -> PlantsScreen(onPlantClick = {})
            }
        }
    }
}