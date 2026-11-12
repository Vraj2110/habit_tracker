package com.example.habit_tracker.presentation.naviagtion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.habit_tracker.presentation.Screens.Calendar.CalendarScreen
import com.example.habit_tracker.presentation.Screens.Groups.GroupScreen
import com.example.habit_tracker.presentation.Screens.Profile.ProfileScreen
import com.example.habit_tracker.presentation.Screens.SignupScreen.SignupScreen
import com.example.habit_tracker.presentation.Screens.Tasks.TaskScreen
import com.example.habit_tracker.presentation.Screens.loginscreen.LoginScreen
import kotlinx.serialization.Serializable

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login) {

        composable<Routes.Login> { LoginScreen(navController) }

        composable<Routes.Signup> { SignupScreen(navController) }


        composable<Routes.Task> { TaskScreen(navController) }

        composable<Routes.Calendar> { CalendarScreen(navController) }

        composable<Routes.Group> { GroupScreen(navController) }

        composable<Routes.Profile> { ProfileScreen(navController) }

    }
    }

