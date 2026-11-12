package com.example.habit_tracker.presentation.Screens.Tasks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.habit_tracker.presentation.UiComponent.MyBottomNavBar
import com.example.habit_tracker.presentation.naviagtion.Routes


@Composable
fun TaskScreen(navController: NavController) {

    Scaffold(
        bottomBar ={ MyBottomNavBar(navController, Routes.Task) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            // Your screen content goes here
        }
    }

}