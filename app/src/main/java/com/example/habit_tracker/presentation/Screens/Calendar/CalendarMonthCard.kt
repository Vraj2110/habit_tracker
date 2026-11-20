package com.example.habit_tracker.presentation.Screens.Calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.Appdefault

private val CompletedDotGreen = Color(0xFF0D9488)
private val ExpiredDotAmber = Color(0xFFB45309)

@Preview
@Composable
fun CalendarMonthCard(darkTheme: Boolean = false) {
    val cardBg = if (darkTheme) Color(0xFF1E222B) else Color.White
    val borderColor = if (darkTheme) Color(0xFF2D3340) else Color(0xFFE8ECF4)
    val primaryText = if (darkTheme) Color.White else Color(0xFF1E293B)
    val mutedText = if (darkTheme) Color(0xFF64748B) else Color(0xFF94A3B8)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = cardBg),
        border = BorderStroke(1.dp, borderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            // Month Title + Arrows
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "October 2026",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryText
                )

                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    IconButton(onClick = {}, modifier = Modifier.size(32.dp)) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Previous Month",
                            tint = Color(0xFF64748B)
                        )
                    }
                    IconButton(onClick = {}, modifier = Modifier.size(32.dp)) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Next Month",
                            tint = Color(0xFF64748B)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Weekday Headers
            Row(modifier = Modifier.fillMaxWidth()) {
                val headers = listOf("M", "T", "W", "T", "F", "S", "S")
                for (day in headers) {
                    Text(
                        text = day,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF64748B)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Week 1: 28, 29, 30 (muted), 1, 2 (green), 3 (amber), 4
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                DayCell(text = "28", textColor = mutedText, modifier = Modifier.weight(1f))
                DayCell(text = "29", textColor = mutedText, modifier = Modifier.weight(1f))
                DayCell(text = "30", textColor = mutedText, modifier = Modifier.weight(1f))
                DayCell(text = "1", textColor = primaryText, dotColors = listOf(CompletedDotGreen), modifier = Modifier.weight(1f))
                DayCell(text = "2", textColor = primaryText, dotColors = listOf(CompletedDotGreen), modifier = Modifier.weight(1f))
                DayCell(text = "3", textColor = primaryText, dotColors = listOf(ExpiredDotAmber), modifier = Modifier.weight(1f))
                DayCell(text = "4", textColor = primaryText, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Week 2: 5, 6 (green), 7 (amber), 8, 9 (green), 10 (amber), 11
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                DayCell(text = "5", textColor = primaryText, dotColors = listOf(CompletedDotGreen), modifier = Modifier.weight(1f))
                DayCell(text = "6", textColor = primaryText, dotColors = listOf(CompletedDotGreen), modifier = Modifier.weight(1f))
                DayCell(text = "7", textColor = primaryText, dotColors = listOf(ExpiredDotAmber), modifier = Modifier.weight(1f))
                DayCell(text = "8", textColor = primaryText, dotColors = listOf(CompletedDotGreen), modifier = Modifier.weight(1f))
                DayCell(text = "9", textColor = primaryText, dotColors = listOf(CompletedDotGreen), modifier = Modifier.weight(1f))
                DayCell(text = "10", textColor = primaryText, dotColors = listOf(ExpiredDotAmber), modifier = Modifier.weight(1f))
                DayCell(text = "11", textColor = primaryText, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Week 3: 12, 13 (green), 14 (selected + 2 dots), 15 (today outline), 16, 17, 18
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                DayCell(text = "12", textColor = primaryText, dotColors = listOf(CompletedDotGreen), modifier = Modifier.weight(1f))
                DayCell(text = "13", textColor = primaryText, dotColors = listOf(CompletedDotGreen), modifier = Modifier.weight(1f))
                DayCell(
                    text = "14",
                    textColor = Color.White,
                    isSelected = true,
                    dotColors = listOf(CompletedDotGreen, ExpiredDotAmber),
                    modifier = Modifier.weight(1f)
                )
                DayCell(
                    text = "15",
                    textColor = primaryText,
                    isToday = true,
                    modifier = Modifier.weight(1f)
                )
                DayCell(text = "16", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "17", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "18", textColor = primaryText, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Week 4: 19 - 25
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                DayCell(text = "19", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "20", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "21", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "22", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "23", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "24", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "25", textColor = primaryText, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Week 5: 26 - 31, 1 (muted)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                DayCell(text = "26", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "27", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "28", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "29", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "30", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "31", textColor = primaryText, modifier = Modifier.weight(1f))
                DayCell(text = "1", textColor = mutedText, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Legend Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(CompletedDotGreen)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "Completed", fontSize = 12.sp, color = Color(0xFF64748B))
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(ExpiredDotAmber)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "Missed / expired", fontSize = 12.sp, color = Color(0xFF64748B))
                }
            }
        }
    }
}

@Composable
private fun DayCell(
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    isToday: Boolean = false,
    dotColors: List<Color> = emptyList()
) {
    Box(
        modifier = modifier
            .height(42.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(if (isSelected) Appdefault else Color.Transparent)
            .then(
                if (isToday) {
                    Modifier.border(
                        width = 1.2.dp,
                        color = Appdefault.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(12.dp)
                    )
                } else Modifier
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = if (isSelected || isToday) FontWeight.Bold else FontWeight.Medium,
                color = textColor
            )
            if (dotColors.isNotEmpty()) {
                Spacer(modifier = Modifier.height(3.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                    dotColors.forEach { dotColor ->
                        Box(
                            modifier = Modifier
                                .size(4.5.dp)
                                .clip(CircleShape)
                                .background(dotColor)
                        )
                    }
                }
            }
        }
    }
}