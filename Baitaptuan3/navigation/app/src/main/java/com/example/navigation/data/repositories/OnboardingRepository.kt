package com.example.navigation.data.repositories

import com.example.navigation.data.local.PrefsDataStore
import com.example.navigation.data.models.OnboardingItem
import com.example.navigation.R
import kotlinx.coroutines.flow.Flow

class OnboardingRepository(private val prefsDataStore: PrefsDataStore) {

    /**
     * Lấy danh sách dữ liệu cho các trang onboarding.
     */
    fun getOnboardingData(): List<OnboardingItem> {
        return listOf(
            OnboardingItem(
                imageResId = R.drawable.time_management, // Thay bằng ID ảnh thật
                title = "Easy Time Management",
                description = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first."
            ),
            OnboardingItem(
                imageResId = R.drawable.work_effectiveness, // Thay bằng ID ảnh thật
                title = "Increase Work Effectiveness",
                description = "Time management and the determination of more important tasks will give you job statistics and always improve."
            ),
            OnboardingItem(
                imageResId = R.drawable.reminder_notification, // Thay bằng ID ảnh thật
                title = "Reminder Notification",
                description = "The advantage of this application is that it also provides reminders for you so you don’t forget to keep doing your assignments well and according to the time you have!"
            )
        )
    }

    /**
     * Kiểm tra xem người dùng đã hoàn thành onboarding chưa.
     */
    fun hasCompletedOnboarding(): Flow<Boolean> {
        return prefsDataStore.hasCompletedOnboarding()
    }

    /**
     * Đặt trạng thái onboarding đã hoàn thành.
     */
    suspend fun setOnboardingCompleted(completed: Boolean) {
        prefsDataStore.setOnboardingCompleted(completed)
    }
}