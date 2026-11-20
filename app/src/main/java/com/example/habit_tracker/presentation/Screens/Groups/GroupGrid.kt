package com.example.habit_tracker.presentation.Screens.Groups
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun GroupGrid(darkTheme: Boolean = false) {
    // Temporary list of 4 identical cards until you connect real data
    val dummyGroups = List(4) { it }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header Row
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your workspaces",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${dummyGroups.size} groups",
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
        }

        // 2-Column Rows of GroupCard
        items(dummyGroups.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                rowItems.forEach { _ ->
                    GroupCard(
                        modifier = Modifier.weight(1f),
                        darkTheme = darkTheme
                    )
                }

                // Keeps half-width alignment if total items is odd (e.g., 3 or 5)
                if (rowItems.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))


                }
            }
        }
    }
}