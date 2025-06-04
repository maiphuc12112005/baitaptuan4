package com.example.navigation.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.navigation.data.models.OnboardingItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pages: List<OnboardingItem>
) {
    HorizontalPager(state = pagerState, modifier = modifier) { page ->
        val item = pages[page]
        OnboardingPageContent(
            imageResId = item.imageResId,
            title = item.title,
            description = item.description
        )
    }
}