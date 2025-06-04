package com.example.navigation.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.navigation.ui.components.OnboardingPageContent
import com.example.navigation.ui.components.PrimaryButton
import com.example.navigation.ui.components.SkipButton
import com.example.navigation.ui.navigation.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    navController: NavController,
    viewModel: OnboardingViewModel = viewModel() // Cần DI cho ViewModel trong thực tế
) {
    val onboardingPages = viewModel.onboardingData
    val pagerState = rememberPagerState(pageCount = { onboardingPages.size })
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Skip Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            SkipButton(onClick = {
                viewModel.setOnboardingCompleted(true)
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            })
        }

        // Pager cho các trang onboarding
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f) // Chiếm phần lớn không gian
        ) { page ->
            val item = onboardingPages[page]
            OnboardingPageContent(
                imageResId = item.imageResId,
                title = item.title,
                description = item.description
            )
        }

        // Navigation buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Nút Back
            if (pagerState.currentPage > 0) {
                PrimaryButton(text = "Back") {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }
            } else {
                // Placeholder hoặc ẩn nút nếu ở trang đầu
                Text("") // Để giữ khoảng cách
            }

            // Nút Next / Get Started
            val buttonText = if (pagerState.currentPage == onboardingPages.size - 1) "Get Started" else "Next"
            PrimaryButton(text = buttonText, modifier = Modifier.weight(1f).padding(start = 16.dp)) {
                if (pagerState.currentPage == onboardingPages.size - 1) {
                    // Đã ở trang cuối cùng, chuyển sang Home
                    viewModel.setOnboardingCompleted(true)
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                } else {
                    // Chuyển sang trang tiếp theo
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            }
        }
    }
}