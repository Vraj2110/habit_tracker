package com.example.habit_tracker.presentation.Screens.Calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habit_tracker.presentation.UiComponent.MyBottomNavBar
import com.example.habit_tracker.presentation.naviagtion.Routes
import com.example.habit_tracker.ui.theme.Appdefault

@Composable
fun CalendarScreen(
    navController: NavController,
    darkTheme: Boolean = false,
    onThemeToggle: () -> Unit = {}
) {
    val screenBg = if (darkTheme) Color(0xFF13161C) else Color(0xFFF8F9FD)
    val sheetBg = if (darkTheme) Color(0xFF181B22) else Color.White
    val primaryText = if (darkTheme) Color.White else Color(0xFF1E293B)

    Scaffold(
        topBar = { CalendarTopBar(darkTheme = darkTheme, onThemeToggle = onThemeToggle) },
        bottomBar = { MyBottomNavBar(navController, Routes.Calendar) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(screenBg)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // Top Header + Calendar Card
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Your work, over time.",
                            fontSize = 14.sp,
                            color = Color(0xFF64748B)
                        )
                        Text(
                            text = "Today",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Appdefault
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    CalendarMonthCard(darkTheme = darkTheme)
                }

                // Bottom Accountability Sheet
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                    color = sheetBg,
                    shadowElevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 18.dp, vertical = 14.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Drag Handle
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .width(36.dp)
                                .height(4.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFCBD5E1))
                        )

                        // Date Heading + Summary
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Wed, October 14",
                                    fontSize = 19.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = primaryText
                                )
                                Text(
                                    text = "2 tasks",
                                    fontSize = 13.sp,
                                    color = Color(0xFF64748B)
                                )
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "1 completed · 1 expired · Accountability log",
                                fontSize = 12.sp,
                                color = Color(0xFF64748B)
                            )
                        }

                        // Task Card 1 (Completed)
                        TaskLogCard(
                            title = "Review navigation flow",
                            groupAndDue = "Design Studio · Due 10:00 AM",
                            badgeLabel = "Completed",
                            isCompleted = true,
                            primaryActor = "Alex Lee",
                            primaryAction = "completed, 9:42 AM",
                            secondaryActor = "Maya Kim",
                            secondaryAction = "verified, 10:05 AM",
                            darkTheme = darkTheme
                        )

                        // Task Card 2 (Expired)
                        TaskLogCard(
                            title = "Prepare test checklist",
                            groupAndDue = "Product Team · Due 2:00 PM",
                            badgeLabel = "Expired",
                            isCompleted = false,
                            primaryActor = "Jordan Davis",
                            primaryAction = "missed deadline, 2:00 PM",
                            secondaryActor = "TaskSync",
                            secondaryAction = "marked expired, 2:01 PM",
                            darkTheme = darkTheme
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}