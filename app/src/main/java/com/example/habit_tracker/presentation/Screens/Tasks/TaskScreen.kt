package com.example.habit_tracker.presentation.Screens.Tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.habit_tracker.presentation.UiComponent.MyBottomNavBar
import com.example.habit_tracker.presentation.naviagtion.Routes

@Composable
fun TaskScreen(
    navController: NavController,
    darkTheme: Boolean = false,
    onThemeToggle: () -> Unit = {}
) {
    Scaffold(
        topBar = { TaskTopbar(darkTheme = darkTheme, onThemeToggle = onThemeToggle) },
        bottomBar = { MyBottomNavBar(navController, Routes.Task) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
        ) {
            TaskProgressCard()

            }
    }
}
