package com.example.habit_tracker.presentation.Screens.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.habit_tracker.presentation.UiComponent.MyBottomNavBar
import com.example.habit_tracker.presentation.naviagtion.Routes

@Composable
fun ProfileScreen(
    navController: NavController,
    darkTheme: Boolean = false,
    onThemeToggle: () -> Unit = {}
) {
    Scaffold(topBar = {ProfileTopBar(darkTheme,onThemeToggle=onThemeToggle)},
        bottomBar = { MyBottomNavBar(navController, Routes.Profile) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {

                ProfileInfoCard { }
            }
        }
    }
}
