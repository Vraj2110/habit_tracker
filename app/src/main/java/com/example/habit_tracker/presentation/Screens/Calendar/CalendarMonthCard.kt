package com.example.habit_tracker.presentation.Screens.Calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

private val CompletedDotGreen = Color(0xFF0D9488)
private val ExpiredDotAmber = Color(0xFFB45309)

private data class CalendarCellData(
    val date: LocalDate,
    val isCurrentMonth: Boolean
)
@Preview
@Composable
fun CalendarMonthCard(
    selectedDate: LocalDate = LocalDate.now(),
    onDateSelected: (LocalDate) -> Unit = {},
    currentMonth: YearMonth = YearMonth.from(selectedDate),
    onMonthChanged: (YearMonth) -> Unit = {},
    // Optional map for status dots: Map<LocalDate, List<Color>>
    statusDots: Map<LocalDate, List<Color>> = emptyMap(),
    darkTheme: Boolean = false
) {
    val cardBg = if (darkTheme) Color(0xFF1E222B) else Color.White
    val borderColor = if (darkTheme) Color(0xFF2D3340) else Color(0xFFE8ECF4)
    val primaryText = if (darkTheme) Color.White else Color(0xFF1E293B)
    val mutedText = if (darkTheme) Color(0xFF64748B) else Color(0xFF94A3B8)

    val today = remember { LocalDate.now() }

    // Generate all cells for the month (Monday-start grid with leading/trailing days)
    val calendarCells = remember(currentMonth) {
        buildMonthGrid(currentMonth)
    }

    val monthTitle = remember(currentMonth) {
        val monthName = currentMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault())
        "$monthName ${currentMonth.year}"
    }

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
            // Month Title + Navigation Arrows
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = monthTitle,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryText
                )

                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    IconButton(
                        onClick = { onMonthChanged(currentMonth.minusMonths(1)) },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Previous Month",
                            tint = Color(0xFF64748B)
                        )
                    }
                    IconButton(
                        onClick = { onMonthChanged(currentMonth.plusMonths(1)) },
                        modifier = Modifier.size(32.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Next Month",
                            tint = Color(0xFF64748B)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Weekday Headers (Monday to Sunday)
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

            // Dynamic Calendar Rows (7 days per week)
            calendarCells.chunked(7).forEachIndexed { weekIndex, week ->
                if (weekIndex > 0) {
                    Spacer(modifier = Modifier.height(6.dp))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    week.forEach { cell ->
                        val isSelected = cell.date == selectedDate
                        val isToday = cell.date == today
                        val dotsForCell = if (cell.isCurrentMonth) {
                            statusDots[cell.date].orEmpty()
                        } else {
                            emptyList()
                        }

                        DayCell(
                            text = cell.date.dayOfMonth.toString(),
                            textColor = when {
                                isSelected -> Color.White
                                !cell.isCurrentMonth -> mutedText
                                else -> primaryText
                            },
                            isSelected = isSelected,
                            isToday = isToday && !isSelected,
                            dotColors = dotsForCell,
                            onClick = {
                                if (!cell.isCurrentMonth) {
                                    onMonthChanged(YearMonth.from(cell.date))
                                }
                                onDateSelected(cell.date)
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
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

private fun buildMonthGrid(yearMonth: YearMonth): List<CalendarCellData> {
    val firstOfMonth = yearMonth.atDay(1)
    // Monday = 1 ... Sunday = 7 -> leading days needed = value - 1
    val leadingDaysCount = firstOfMonth.dayOfWeek.value - 1
    val prevMonth = yearMonth.minusMonths(1)
    val daysInPrevMonth = prevMonth.lengthOfMonth()

    val cells = mutableListOf<CalendarCellData>()

    // 1. Leading days from previous month
    for (i in (daysInPrevMonth - leadingDaysCount + 1)..daysInPrevMonth) {
        cells.add(CalendarCellData(prevMonth.atDay(i), isCurrentMonth = false))
    }

    // 2. Days of current month
    for (day in 1..yearMonth.lengthOfMonth()) {
        cells.add(CalendarCellData(yearMonth.atDay(day), isCurrentMonth = true))
    }

    // 3. Trailing days from next month to complete the final 7-day row
    val nextMonth = yearMonth.plusMonths(1)
    val remainingSlots = (7 - (cells.size % 7)) % 7
    for (day in 1..remainingSlots) {
        cells.add(CalendarCellData(nextMonth.atDay(day), isCurrentMonth = false))
    }

    return cells
}

@Composable
private fun DayCell(
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    isToday: Boolean = false,
    dotColors: List<Color> = emptyList(),
    onClick: () -> Unit = {}
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
            )
            .clickable { onClick() },
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