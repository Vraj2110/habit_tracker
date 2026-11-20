package com.example.habit_tracker.presentation.Screens.Groups

import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.R
import com.example.habit_tracker.ui.theme.Appdefault
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun GroupCard(darkTheme: Boolean = false,
              modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.height(190.dp).width(175.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (darkTheme) Color(0xFF1E222B) else Color.White
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (darkTheme) Color(0xFF2D3340) else Color(0xFFE8ECF4)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.Start
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(13.dp))
                        .background(Appdefault.copy(alpha = if (darkTheme) 0.22f else 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Layers,
                        contentDescription = "Layers Logo",
                        tint = Appdefault
                    )
                }
                Box(
                    modifier = Modifier
                        .size(31.dp)
                        .clip(CircleShape)
                        .background(Appdefault.copy(alpha = if (darkTheme) 0.22f else 0.12f))
                        .clickable { },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "VD",
                        color = if (darkTheme) Color(0xFFA5B4FC) else Appdefault,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }


            Spacer(modifier = Modifier.height(13.dp))
            Text(
                "Product Team",
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W400
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                "October sprint",
                fontSize = 12.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W400,
                color = Color.Gray
            )

            Row(modifier = Modifier.fillMaxWidth()
                .padding(0.dp),
                horizontalArrangement = Arrangement.Start
            ) {GroupProgressBar() }


        }
    }

}