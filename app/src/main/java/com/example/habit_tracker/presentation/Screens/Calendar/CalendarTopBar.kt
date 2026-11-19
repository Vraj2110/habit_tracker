package com.example.habit_tracker.presentation.Screens.Calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.Appdefault

@Preview
@Composable
fun CalendarTopBar( darkTheme: Boolean = false,
                    userInitials: String = "VD",
                    onThemeToggle: () -> Unit = {},
                    onProfileClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left: App Title
            Text(
                text = "Calendar",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = FontFamily.SansSerif
            )

            // Right: Theme Toggle + Profile Badge grouped together
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Theme Toggle Switch Pill
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(if (darkTheme) Color(0xFF161920) else Color(0xFFF1F5F9))
                        .border(
                            width = 1.dp,
                            color = if (darkTheme) Color(0xFF2A2F3D) else Color(0xFFE2E8F0),
                            shape = CircleShape
                        )
                        .clickable { onThemeToggle() }
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Sun Icon (Light Mode)
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(if (!darkTheme) Appdefault else Color.Transparent),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.WbSunny,
                            contentDescription = "Light Mode",
                            tint = if (!darkTheme) Color.White else Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(2.dp))

                    // Moon Icon (Dark Mode)
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(if (darkTheme) Appdefault else Color.Transparent),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.DarkMode,
                            contentDescription = "Dark Mode",
                            tint = if (darkTheme) Color.White else Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                // Profile Initials Circle
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Appdefault.copy(alpha = if (darkTheme) 0.22f else 0.12f))
                        .clickable { onProfileClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = userInitials.take(2).uppercase(),
                        color = if (darkTheme) Color(0xFFA5B4FC) else Appdefault,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}