package com.example.navigation.ui.screens.splash

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
// import androidx.compose.foundation.layout.wrapContentSize // Không cần thiết khi dùng size() hoặc fillMaxWidth/Height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.navigation.R
import com.example.navigation.ui.navigation.Screen
import kotlinx.coroutines.delay
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column // Cần import này để sắp xếp theo chiều dọc
import androidx.compose.foundation.layout.Arrangement // Cần import này để sắp xếp verticalArrangement
import androidx.compose.foundation.layout.size // Cần import này để đặt kích thước cụ thể

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = viewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.onboardingCompleted.collect { completed ->
            delay(3000)
            if (completed) {
                navController.popBackStack()
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true } // Xóa tất cả các màn hình splash và trước đó
                }
            } else {
                navController.popBackStack()
                navController.navigate(Screen.Onboarding.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // Đổi màu nền thành trắng
        contentAlignment = Alignment.Center // Căn giữa nội dung của Box
    ) {
        // Sử dụng Column để sắp xếp Logo và Text theo chiều dọc
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Căn giữa các phần tử theo chiều ngang trong Column
            verticalArrangement = Arrangement.Center // Căn giữa các phần tử theo chiều dọc trong Column
        ) {
            Image(
                painter = painterResource(id = R.drawable.uth), // Thay bằng ID logo của bạn
                contentDescription = "UTH SmartTasks Logo",
                modifier = Modifier.size(200.dp) // Đặt kích thước cố định cho logo, bạn có thể điều chỉnh
            )
            Text(
                text = "UTH SmartTasks",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary // Sử dụng màu primary cho chữ
                ),
                modifier = Modifier.padding(top = 16.dp) // Thêm khoảng cách giữa logo và chữ
            )
        }
    }
}