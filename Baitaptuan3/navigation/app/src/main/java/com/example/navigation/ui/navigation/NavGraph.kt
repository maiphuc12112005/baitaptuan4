package com.example.navigation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigation.ui.screens.home.HomeScreen
import com.example.navigation.ui.screens.onboarding.OnboardingScreen
import com.example.navigation.ui.screens.splash.SplashScreen

/**
 * Định nghĩa biểu đồ điều hướng (NavGraph) của ứng dụng.
 * @param navController NavHostController để quản lý việc điều hướng.
 */
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route // Màn hình khởi đầu là Splash
    ) {
        // Màn hình Splash
        composable(route = Screen.Splash.route) {
            // Cung cấp NavController cho SplashScreen để nó có thể điều hướng đi
            SplashScreen(navController = navController)
        }

        // Màn hình Onboarding
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }

        // Màn hình Home
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        // Màn hình Login (nếu có)
        // composable(route = Screen.Login.route) {
        //     LoginScreen(navController = navController)
        // }
    }
}