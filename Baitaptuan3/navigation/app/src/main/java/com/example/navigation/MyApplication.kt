package com.example.navigation

import android.app.Application
// import dagger.hilt.android.HiltAndroidApp // Ví dụ nếu dùng Hilt

// @HiltAndroidApp // Annotation cho Hilt
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Khởi tạo các thư viện hoặc cấu hình toàn cục nếu cần
        // Ví dụ: khởi tạo Timber, Room database, v.v.
    }
}