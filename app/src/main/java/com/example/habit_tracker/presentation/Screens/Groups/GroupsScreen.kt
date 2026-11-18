package com.example.habit_tracker.presentation.Screens.Groups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.habit_tracker.presentation.UiComponent.MyBottomNavBar
import com.example.habit_tracker.presentation.naviagtion.Routes

@Composable
fun GroupScreen(
    navController: NavController,
    darkTheme: Boolean = false,
    onThemeToggle: () -> Unit = {}
) {
    Scaffold(
        topBar = { GroupTopBar(darkTheme = darkTheme, onThemeToggle = onThemeToggle) },
        bottomBar = { MyBottomNavBar(navController, Routes.Group) }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(all = 10.dp)
        ) {

            Spacer(modifier = Modifier.height(25.dp))

            Row(modifier = Modifier
                .padding(start = 10.dp)) {
                Text(text = "Shared goals. Clear next steps.",
                    color = Color.Gray,
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(12.dp))

            GroupBothButton()
            Row(modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {

                Text("your workspaces",
                    fontSize = 20.sp)
                Text("4 Groups")
            }

        }


    }
}
