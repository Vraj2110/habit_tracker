package com.example.habit_tracker.presentation.Screens.Tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habit_tracker.presentation.UiComponent.MyBottomNavBar
import com.example.habit_tracker.presentation.naviagtion.Routes
import com.example.habit_tracker.ui.theme.Appdefault

@Composable
fun TaskScreen(
    navController: NavController,
    darkTheme: Boolean = false,
    onThemeToggle: () -> Unit = {}
) {
    val todayTasks = listOf(
        TaskItem("Review homepage wireframes", "Design Studio", "High", "Today, 10:00 AM", false),
        TaskItem("Prepare sprint planning", "Product Team", "Medium", "Today, 11:30 AM", false),
        TaskItem("Update project checklist", "Design Studio", "Low", "Today, 2:00 PM", false)
    )

    Scaffold(
        topBar = { TaskTopbar(darkTheme = darkTheme, onThemeToggle = onThemeToggle) },
        bottomBar = { MyBottomNavBar(navController, Routes.Task) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            Column(
                modifier = Modifier.padding(start = 4.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "THURSDAY, OCTOBER 15",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Make room for progress.",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            TaskProgressCard(darkTheme = darkTheme)
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Today's Active Tasks",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "View all",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Appdefault
                    )
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "View all",
                        tint = Appdefault,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(todayTasks) { task ->
                    TaskCard(task = task, darkTheme = darkTheme)
                }
            }
        }
    }
}
