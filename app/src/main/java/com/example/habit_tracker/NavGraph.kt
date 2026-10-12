package com.example.habit_tracker

import androidx.compose.runtime.Composable

@Composable
breadcrumbs
fun HabitNavGraph() {
    val navController = ()

    NavHost(
        navController = navController,
        startDestination = "home_screen" // The screen you want to navigate to after splash
    ) {
        composable("home_screen") {
            HomeScreen(
                onNavigateToAddHabit = {
                    navController.navigate("add_habit_screen")
                }
            )
        }
        composable("add_habit_screen") {
            AddHabitScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}