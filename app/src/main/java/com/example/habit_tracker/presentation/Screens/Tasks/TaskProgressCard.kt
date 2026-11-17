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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.R
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
            .fillMaxWidth()
            .padding(10.dp)
            .size(width = 350.dp, height = 250.dp)
    ) {

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Text(
                text = "Your daily momentum",
                fontSize = 19.sp,
                modifier = Modifier
                    .padding(13.dp),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal

            )

            Text(
                text = "Today",
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,

                modifier = Modifier.padding(13.dp)
            )

        }

        Row(modifier = Modifier.fillMaxWidth().padding(start = 21.dp),
            verticalAlignment = Alignment.CenterVertically) {

            CircularProgressIndicator(
                progress = { 0.67f },
                modifier = Modifier.size(100.dp),
                color = Appdefault,
                trackColor = Color(0xFFEEF0FF),
                strokeWidth = 7.dp,
                strokeCap = StrokeCap.Square
            )

            Spacer(Modifier.width(15.dp))

            Column(modifier = Modifier) {

                Completedprogress()

                Spacer(modifier = Modifier.height(18.dp))

                PendingProgress()



            }


            }
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start

            // Space between icon and text
        ) {
            Icon(
               painter = painterResource(R.drawable.treading_up),
                contentDescription = null, // Set a description if the icon conveys unique meaning
                modifier = Modifier.size(18.dp),
                tint = Appdefault
            )
            Text(text = "2 more completed than yesterday.Keep it up!",
                modifier = Modifier.padding(start = 20.dp))
        }


        }
    }
