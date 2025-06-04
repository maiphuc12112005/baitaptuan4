package com.example.navigation.ui.navigation

/**
 * Định nghĩa các route cho các màn hình trong ứng dụng.
 */
sealed class Screen(val route: String) {
    // Màn hình Splash
    object Splash : Screen("splash_route")

    // Màn hình Onboarding
    object Onboarding : Screen("onboarding_route")

    // Màn hình Home (sau khi hoàn thành onboarding)
    object Home : Screen("home_route")

    // Màn hình Login (nếu có)
    object Login : Screen("login_route")

    // Nếu có các route với đối số, bạn có thể định nghĩa như sau:
    // object Detail : Screen("detail_route/{itemId}") {
    //     fun createRoute(itemId: String) = "detail_route/$itemId"
    // }
}