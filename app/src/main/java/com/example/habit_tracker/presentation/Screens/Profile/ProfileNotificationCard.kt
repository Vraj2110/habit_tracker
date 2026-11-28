package com.example.habit_tracker.presentation.Screens.Profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.R
import com.example.habit_tracker.ui.theme.Appdefault

@Composable
fun ProfileNotificationCard(darkTheme: Boolean = false) {
    var isEnabled by remember { mutableStateOf(true) }
    var isFeedBack by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (darkTheme) Color(0xFF161920) else Color.White
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (darkTheme) Color(0xFF2A2F3D) else Color(0xFFE2E8F0)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.bell),
                contentDescription = "Notification",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Task assignments",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "When a teammate assigns you work",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
            }

            Switch(
                checked = isEnabled,
                onCheckedChange = { isEnabled = it },
                colors = SwitchColors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Appdefault,
                    checkedBorderColor = Color.Transparent,
                    checkedIconColor = Color.Transparent,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray,
                    uncheckedBorderColor = Color.LightGray,
                    uncheckedIconColor = Color.LightGray,
                    disabledCheckedThumbColor = Color.Transparent,
                    disabledCheckedTrackColor = Color.Transparent,
                    disabledCheckedBorderColor = Color.Transparent,
                    disabledCheckedIconColor = Color.Transparent,
                    disabledUncheckedThumbColor = Color.Transparent,
                    disabledUncheckedTrackColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent,
                    disabledUncheckedIconColor = Color.Transparent
                )
            )
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = if (darkTheme) Color(0xFF2A2F3D) else Color(0xFFF1F5F9)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.calendarlogo),
                contentDescription = "Calendar",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Due date reminders",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "30 minutes before a deadline",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
            }

            Switch(
                checked = isFeedBack,
                onCheckedChange = { isFeedBack = it },
                colors = SwitchColors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Appdefault,
                    checkedBorderColor = Color.Transparent,
                    checkedIconColor = Color.Transparent,
                    uncheckedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray,
                    uncheckedBorderColor = Color.LightGray,
                    uncheckedIconColor = Color.LightGray,
                    disabledCheckedThumbColor = Color.Transparent,
                    disabledCheckedTrackColor = Color.Transparent,
                    disabledCheckedBorderColor = Color.Transparent,
                    disabledCheckedIconColor = Color.Transparent,
                    disabledUncheckedThumbColor = Color.Transparent,
                    disabledUncheckedTrackColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent,
                    disabledUncheckedIconColor = Color.Transparent
                )
            )
        }
    }
}
