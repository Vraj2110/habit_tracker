package com.example.habit_tracker.presentation.Screens.Tasks

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.R
import com.example.habit_tracker.ui.theme.Appdefault

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskCard() {

    var checked by remember { mutableStateOf(true) }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .size(height = 140.dp, width = 350.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Review homepage wireframes",
                modifier = Modifier.padding(start = 60.dp, top = 15.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif
            )

            Row(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Appdefault,
                        uncheckedColor = Color.Gray,
                    ),
                    modifier = Modifier
                        .size(40.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Design Studio",
                        modifier = Modifier.padding(top = 2.dp),
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray,
                    )

                    Text(
                        text = "High",
                        modifier = Modifier
                            .background(
                                color = Color.Red.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 13.dp, vertical = 3.dp),
                        color = Color(0xFFC04258),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 60.dp, bottom = 20.dp, end = 10.dp),
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    painter = painterResource(R.drawable.clock),
                    contentDescription = "watch",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(17.dp)
                )

                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    "Today",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 13.sp
                )

                Text(",",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 13.sp)

                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    "2:00 PM",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 13.sp
                )


            }
        }


    }

}
