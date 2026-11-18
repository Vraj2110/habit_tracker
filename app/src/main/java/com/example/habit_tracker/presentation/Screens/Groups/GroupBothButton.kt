package com.example.habit_tracker.presentation.Screens.Groups

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.R
import com.example.habit_tracker.ui.theme.Appdefault
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun GroupBothButton() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {

        ElevatedButton(
            onClick = {},
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
            modifier = Modifier
                .size(190.dp, 60.dp),
            colors = ButtonColors(
                containerColor = Appdefault,
                contentColor = Color.White,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            ),
            shape = RoundedCornerShape(12.dp),

            ) {
            Icon(
                painter = painterResource(R.drawable.add),
                contentDescription = "Key", modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                "Create Group",
                maxLines = 1,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        ElevatedButton(
            onClick = { },
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
            modifier = Modifier
                .size(190.dp, 60.dp),
            colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContentColor = Color.Unspecified,
                disabledContainerColor = Color.Unspecified
            ),
            shape = RoundedCornerShape(12.dp)
        ) {

            Icon(
                painter = painterResource(R.drawable.key),
                contentDescription = "Key", modifier = Modifier.size(20.dp),
                tint = Color.Black
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                "Join with Code",
                maxLines = 1,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        }

    }

}