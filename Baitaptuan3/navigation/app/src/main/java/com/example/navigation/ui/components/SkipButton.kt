package com.example.navigation.ui.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SkipButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick, modifier = modifier) {
        Text(text = "Skip", color = Color.Gray) // Bạn có thể định nghĩa màu này trong theme
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSkipButton() {
    SkipButton {}
}