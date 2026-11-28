package com.example.habit_tracker.presentation.Screens.Tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.R
import com.example.habit_tracker.ui.theme.Appdefault

data class TaskItem(
    val title: String,
    val category: String,
    val priority: String, // "High", "Medium", "Low"
    val time: String,
    val initialChecked: Boolean = false
)

@Composable
fun TaskCard(
    task: TaskItem,
    darkTheme: Boolean = false
) {
    var checked by remember { mutableStateOf(task.initialChecked) }

    val priorityBg = when (task.priority.lowercase()) {
        "high" -> if (darkTheme) Color(0xFF4C1D1D) else Color(0xFFFFE4E6)
        "medium" -> if (darkTheme) Color(0xFF451A03) else Color(0xFFFEF3C7)
        else -> if (darkTheme) Color(0xFF064E3B) else Color(0xFFDCFCE7)
    }

    val priorityText = when (task.priority.lowercase()) {
        "high" -> if (darkTheme) Color(0xFFFCA5A5) else Color(0xFFE11D48)
        "medium" -> if (darkTheme) Color(0xFFFCD34D) else Color(0xFFD97706)
        else -> if (darkTheme) Color(0xFF86EFAC) else Color(0xFF16A34A)
    }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (darkTheme) Color(0xFF161920) else Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Appdefault,
                            uncheckedColor = Color.Gray
                        ),
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = task.title,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Text(
                    text = task.priority,
                    modifier = Modifier
                        .background(
                            color = priorityBg,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    color = priorityText,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = task.category,
                    fontSize = 13.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.clock),
                        contentDescription = "Time",
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )
                    Text(
                        text = task.time,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
