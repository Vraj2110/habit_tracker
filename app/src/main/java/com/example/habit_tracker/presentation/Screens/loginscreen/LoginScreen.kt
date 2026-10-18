package com.example.habit_tracker.presentation.Screens.loginscreen

import android.graphics.Paint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.presentation.UiComponent.TopBar


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {

    Column() {

        Spacer(modifier = Modifier.height(15.dp))
        TopBar()

        Column(modifier = Modifier.fillMaxWidth()
            .padding(start = 20.dp)) {

            Spacer(modifier = Modifier.height(35.dp))
            Text(text = "Welcome back",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Log in to pick up where you left off",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.DarkGray.copy(alpha = 0.5f),
                textAlign = TextAlign.Center
                )


        }
    }
}