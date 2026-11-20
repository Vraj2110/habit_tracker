package com.example.habit_tracker.presentation.Screens.Groups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.Appdefault

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GroupProgressBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Start
            ) {

                Text(
                    text = "3/9",
                    fontSize = 15.sp,
                    color = Color(0xFF70809F),
                    fontWeight = FontWeight.W400
                )

                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Task done",
                    fontSize = 15.sp,
                    color = Color(0xFF70809F)
                )
            }

            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "33%",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Appdefault
                )
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        LinearProgressIndicator(
            progress = { 0.33f },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp),
            color = Appdefault,
            trackColor = Color(0xFFEEF0FF),
            strokeCap = StrokeCap.Round,
            drawStopIndicator = {},
            gapSize = 0.dp
        )
    }
}