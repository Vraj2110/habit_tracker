package com.example.habit_tracker.presentation.Screens.Calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TaskLogCard(
    title: String,
    groupAndDue: String,
    badgeLabel: String,
    isCompleted: Boolean,
    primaryActor: String,
    primaryAction: String,
    secondaryActor: String,
    secondaryAction: String,
    darkTheme: Boolean = false
) {
    val cardBg = if (darkTheme) Color(0xFF1E222B) else Color.White
    val borderColor = if (darkTheme) Color(0xFF2D3340) else Color(0xFFE8ECF4)
    val titleColor = if (darkTheme) Color.White else Color(0xFF1E293B)
    val subTextColor = if (darkTheme) Color(0xFF94A3B8) else Color(0xFF64748B)

    val badgeBg = if (isCompleted) Color(0xFFE6F6F0) else Color(0xFFFEF3C7)
    val badgeText = if (isCompleted) Color(0xFF0D9488) else Color(0xFFB45309)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = cardBg),
        border = BorderStroke(1.dp, borderColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = titleColor
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(badgeBg)
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = badgeLabel,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = badgeText
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = groupAndDue,
                fontSize = 12.sp,
                color = subTextColor
            )

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 12.dp),
                thickness = 1.dp,
                color = borderColor
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(fontWeight = FontWeight.SemiBold, color = titleColor)) {
                        append(primaryActor)
                    }
                    withStyle(SpanStyle(color = subTextColor)) {
                        append(" · $primaryAction")
                    }
                },
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(fontWeight = FontWeight.Medium, color = subTextColor)) {
                        append(secondaryActor)
                    }
                    withStyle(SpanStyle(color = subTextColor)) {
                        append(" · $secondaryAction")
                    }
                },
                fontSize = 12.sp
            )
        }
    }
}