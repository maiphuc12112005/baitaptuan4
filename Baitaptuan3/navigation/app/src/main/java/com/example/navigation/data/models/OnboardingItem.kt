package com.example.navigation.data.models

import androidx.annotation.DrawableRes


data class OnboardingItem(
    @DrawableRes val imageResId: Int,
    val title: String,
    val description: String
)