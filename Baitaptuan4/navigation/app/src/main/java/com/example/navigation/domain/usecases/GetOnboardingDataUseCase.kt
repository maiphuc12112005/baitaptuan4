package com.example.navigation.domain.usecases

import com.example.navigation.data.models.OnboardingItem
import com.example.navigation.data.repositories.OnboardingRepository

/**
 * Use case để lấy dữ liệu cho các trang onboarding.
 */
class GetOnboardingDataUseCase(private val repository: OnboardingRepository) {
    operator fun invoke(): List<OnboardingItem> {
        return repository.getOnboardingData()
    }
}