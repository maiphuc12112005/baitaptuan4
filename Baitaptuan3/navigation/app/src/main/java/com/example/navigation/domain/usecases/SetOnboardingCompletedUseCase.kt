package com.example.navigation.domain.usecases

import com.example.navigation.data.repositories.OnboardingRepository

/**
 * Use case để đánh dấu rằng quá trình onboarding đã hoàn thành.
 */
class SetOnboardingCompletedUseCase(private val repository: OnboardingRepository) {
    suspend operator fun invoke(completed: Boolean) {
        repository.setOnboardingCompleted(completed)
    }
}