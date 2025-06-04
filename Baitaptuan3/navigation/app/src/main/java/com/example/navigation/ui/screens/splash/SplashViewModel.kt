package com.example.navigation.ui.screens.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigation.data.local.PrefsDataStore
import com.example.navigation.data.local.dataStore
import com.example.navigation.data.repositories.OnboardingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val prefsDataStore = PrefsDataStore(application.applicationContext)
    private val onboardingRepository = OnboardingRepository(prefsDataStore)

    private val _onboardingCompleted = MutableStateFlow(false)
    val onboardingCompleted: StateFlow<Boolean> = _onboardingCompleted.asStateFlow()

    init {
        checkOnboardingStatus()
    }

    private fun checkOnboardingStatus() {
        viewModelScope.launch {
            onboardingRepository.hasCompletedOnboarding().collectLatest { completed ->
                _onboardingCompleted.value = completed
            }
        }
    }
}