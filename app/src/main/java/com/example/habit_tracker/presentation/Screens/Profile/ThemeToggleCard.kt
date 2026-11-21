package com.example.habit_tracker.presentation.Screens.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.ui.theme.Appdefault

@Composable
fun ThemeToggleCard(
    darkTheme: Boolean,
    onThemeToggle: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .clip(CircleShape)
            .background(if (darkTheme) Color(0xFF13161C) else Color(0xFFF1F5F9))
            .border(
                width = 1.dp,
                color = if (darkTheme) Color(0xFF2A2F3D) else Color(0xFFE2E8F0),
                shape = CircleShape
            )
            .padding(4.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Sun Icon (Light Mode)
        Row(
            modifier = Modifier
                .weight(1f)
                .height(45.dp)
                .clip(CircleShape)
                .background(if (!darkTheme) Appdefault else Color.Transparent)
                .clickable { if (darkTheme) onThemeToggle(false) },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.WbSunny,
                contentDescription = "Light Mode",
                tint = if (!darkTheme) Color.White else Color.Gray,
                modifier = Modifier.size(16.dp),
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "Light Mode",
                color = if (!darkTheme) Color.White else Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(2.dp))

        // Moon Icon (Dark Mode)
        Row(
            modifier = Modifier
                .weight(1f)
                .height(45.dp)
                .clip(CircleShape)
                .background(if (darkTheme) Appdefault else Color.Transparent)
                .clickable { if (!darkTheme) onThemeToggle(true) },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.DarkMode,
                contentDescription = "Dark Mode",
                tint = if (darkTheme) Color.White else Color.Gray,
                modifier = Modifier.size(16.dp)
            )

            Spacer(modifier = Modifier.width(3.dp))

            Text(
                text = "Dark Mode",
                color = if (darkTheme) Color.White else Color.Gray
            )
        }
    }
}
