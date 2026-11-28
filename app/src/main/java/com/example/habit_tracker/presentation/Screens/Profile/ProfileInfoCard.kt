package com.example.habit_tracker.presentation.Screens.Profile

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habit_tracker.ui.theme.Appdefault

@Composable
fun ProfileInfoCard(
    darkTheme: Boolean = false,
    onProfileClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (darkTheme) Color(0xFF161920) else Color.White
        ),
        border = BorderStroke(
            width = 1.dp,
            color = if (darkTheme) Color(0xFF2A2F3D) else Color(0xFFE2E8F0)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(Appdefault.copy(alpha = if (darkTheme) 0.22f else 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "VD",
                    color = if (darkTheme) Color(0xFFA5B4FC) else Appdefault,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // User Info & Tags
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Vraj Desai",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Vraj@university.edu",
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Student",
                        color = Appdefault,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Appdefault.copy(alpha = if (darkTheme) 0.22f else 0.12f))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )

                    Text(
                        text = "Developer",
                        color = Appdefault,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Appdefault.copy(alpha = if (darkTheme) 0.22f else 0.12f))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }
            }

            // Edit Button
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Profile Info",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
