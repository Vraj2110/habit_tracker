package com.example.habit_tracker.presentation.naviagtion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.habit_tracker.presentation.Screens.Calendar.CalendarScreen
import com.example.habit_tracker.presentation.Screens.Groups.GroupScreen
import com.example.habit_tracker.presentation.Screens.Profile.ProfileScreen
import com.example.habit_tracker.presentation.Screens.SignupScreen.SignupScreen
import com.example.habit_tracker.presentation.Screens.Tasks.TaskScreen
import com.example.habit_tracker.presentation.Screens.loginscreen.LoginScreen

@Composable
fun NavGraph(darkTheme: Boolean, onThemeToggle: () -> Unit) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login) {
        composable<Routes.Login> {
            LoginScreen(navController, darkTheme, onThemeToggle)
        }
        composable<Routes.Signup> {
            SignupScreen(navController, darkTheme, onThemeToggle)
        }
        composable<Routes.Task> {
            TaskScreen(navController, darkTheme, onThemeToggle)
        }
        composable<Routes.Calendar> {
            CalendarScreen(navController, darkTheme, onThemeToggle)
        }
        composable<Routes.Group> {
            GroupScreen(navController, darkTheme, onThemeToggle)
        }
        composable<Routes.Profile> {
            ProfileScreen(navController, darkTheme, onThemeToggle)
        }
    }
}
