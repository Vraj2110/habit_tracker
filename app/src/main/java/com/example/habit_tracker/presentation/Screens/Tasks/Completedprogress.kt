package com.example.habit_tracker.presentation.Screens.Tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.Appdefault

@Composable
fun Completedprogress(darkTheme: Boolean = false) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Completed",
                fontSize = 15.sp,
                color = Color.Gray
            )

            Text(
                text = "08",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = if (darkTheme) Color.White else Color(0xFF192238)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        LinearProgressIndicator(
            progress = { 0.67f },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = Appdefault,
            trackColor = if (darkTheme) Color(0xFF2A2F3D) else Color(0xFFEEF0FF),
            strokeCap = StrokeCap.Round,
            drawStopIndicator = {},
            gapSize = 0.dp
        )
    }
}
