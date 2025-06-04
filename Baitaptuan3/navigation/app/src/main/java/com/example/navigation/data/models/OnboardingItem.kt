package com.example.navigation.data.models

import androidx.annotation.DrawableRes

/**
 * Data class biểu diễn một mục (trang) trong quá trình onboarding.
 */
data class OnboardingItem(
    @DrawableRes val imageResId: Int, // ID tài nguyên hình ảnh
    val title: String,
    val description: String
)