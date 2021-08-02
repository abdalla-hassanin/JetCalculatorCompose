package com.abdalla.jetcaluclatorcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import com.abdalla.jetcaluclatorcompose.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor= 0xFF000000.toInt()
        setContent {
            HomeScreen()
        }
    }
}
