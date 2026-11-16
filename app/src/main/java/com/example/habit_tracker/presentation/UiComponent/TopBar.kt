package com.example.habit_tracker.presentation.UiComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.Appdefault

@Composable
fun TopBar(
    darkTheme: Boolean = false,
    onThemeToggle: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // App Logo and Name
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Default.TaskAlt,
                    contentDescription = "TaskSync Logo",
                    tint = Appdefault
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "TaskSync",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = FontFamily.SansSerif
            )
        }

        // Theme Toggle Switch Pill
        Row(
            modifier = Modifier
                .background(
                    color = if (darkTheme) Color(0xFF161920) else Color(0xFFF1F5F9),
                    shape = RoundedCornerShape(50.dp)
                )
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Sun Icon (Light Mode)
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(
                        color = if (!darkTheme) Appdefault else Color.Transparent,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .clickable { if (darkTheme) onThemeToggle() },
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
                    .background(
                        color = if (darkTheme) Appdefault else Color.Transparent,
                        shape = RoundedCornerShape(50.dp)
                    )
                    .clickable { if (!darkTheme) onThemeToggle() },
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
    }
}
