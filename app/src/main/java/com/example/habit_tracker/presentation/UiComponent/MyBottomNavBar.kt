package com.example.habit_tracker.presentation.UiComponent

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.habit_tracker.R
import com.example.habit_tracker.presentation.naviagtion.Routes
import com.example.habit_tracker.ui.theme.Appdefault

@Composable
fun MyBottomNavBar(navController: NavController, routes: Routes) {

    val navItems = listOf(
        NavItem("Task", R.drawable.tasklogo, Routes.Task),
        NavItem("Groups", R.drawable.groupslogo, Routes.Group),
        NavItem("Calendar", R.drawable.calendarlogo, Routes.Calendar),
        NavItem("profile", R.drawable.profilelogo, Routes.Profile)
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(80.dp)
    ) {

        navItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(item.title) },
                onClick = {
                    if (item.routes != routes) {
                        navController.navigate(item.routes) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selected = item.routes == routes,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Appdefault,
                    selectedTextColor = Appdefault,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = Appdefault.copy(alpha = 0.08f)
                )
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: Int,
    val routes: Routes
)
