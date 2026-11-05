package com.example.habit_tracker.presentation.UiComponent

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.habit_tracker.R
import com.example.habit_tracker.ui.theme.Appdefault

@Preview
@Composable
fun MyBottomNavBar() {

    val navItems = listOf(
        NavItem("Task", R.drawable.tasklogo),
        NavItem("Groups", R.drawable.groupslogo),
        NavItem("Calendar", R.drawable.calendarlogo),
        NavItem("profile", R.drawable.profilelogo)
    )

    NavigationBar(containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ) {

        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                modifier = Modifier.size(30.dp),
                //handling bottom navbar
                onClick = {},
                selected = item.routes == routes,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Appdefault,
                    selectedTextColor = Appdefault,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = Appdefault.copy(alpha = 0.03f)
                )
            )
        }
    }
}

}

data class NavItem(
    val title: String,
    val icon: Int
)