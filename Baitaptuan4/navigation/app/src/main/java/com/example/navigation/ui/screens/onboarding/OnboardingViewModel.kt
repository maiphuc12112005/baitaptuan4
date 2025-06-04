package com.example.navigation.ui.screens.onboarding

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigation.data.local.PrefsDataStore
import com.example.navigation.data.local.dataStore
import com.example.navigation.data.models.OnboardingItem
import com.example.navigation.data.repositories.OnboardingRepository
import com.example.navigation.domain.usecases.GetOnboardingDataUseCase
import com.example.navigation.domain.usecases.SetOnboardingCompletedUseCase
import kotlinx.coroutines.launch

class OnboardingViewModel(application: Application) : AndroidViewModel(application) {

    // Khởi tạo các dependency (trong thực tế nên dùng DI)
    private val prefsDataStore = PrefsDataStore(application.applicationContext)
    private val onboardingRepository = OnboardingRepository(prefsDataStore)
    private val getOnboardingDataUseCase = GetOnboardingDataUseCase(onboardingRepository)
    private val setOnboardingCompletedUseCase = SetOnboardingCompletedUseCase(onboardingRepository)

    // Dữ liệu cho các trang onboarding
    private val _onboardingData = mutableStateListOf<OnboardingItem>()
    val onboardingData: SnapshotStateList<OnboardingItem> = _onboardingData

    init {
        _onboardingData.addAll(getOnboardingDataUseCase())
    }

    /**
     * Đánh dấu rằng quá trình onboarding đã hoàn thành.
     */
    fun setOnboardingCompleted(completed: Boolean) {
        viewModelScope.launch {
            setOnboardingCompletedUseCase(completed)
        }
    }
}