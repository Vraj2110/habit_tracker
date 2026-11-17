package com.example.habit_tracker.presentation.Screens.Tasks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.Appdefault

@Preview
@Composable
fun TaskProgressCard() {

    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(width = 250.dp, height = 150.dp)
    ) {

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Text(
                text = "Your daily momentum",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(13.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W300

            )

            Text(
                text = "Today",
                fontSize = 10.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W400,
                color = Color.Gray,

                modifier = Modifier.padding(13.dp)
            )

        }

        Row(modifier = Modifier.fillMaxWidth().padding(start = 21.dp),
            verticalAlignment = Alignment.CenterVertically) {

            CircularProgressIndicator(
                progress = { 0.67f },
                modifier = Modifier.size(60.dp),
                color = Appdefault,
                trackColor = Color(0xFFEEF0FF),
                strokeWidth = 7.dp
            )

            Spacer(Modifier.width(15.dp))

            Column(modifier = Modifier) {

                Completedprogress()

                Spacer(modifier = Modifier.height(18.dp))

                PendingProgress()
            }


            }
        }
    }
