package com.example.habit_tracker.presentation.Screens.Profile

import android.widget.Switch
import android.widget.ToggleButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SwitchColors
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
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habit_tracker.R
import com.example.habit_tracker.ui.theme.Appdefault

@Preview
@Composable
fun ProfileAppPreferencesToggleCard() {

    var isEnabled by remember { mutableStateOf(true) }
    var isFeedBack by remember { mutableStateOf(true) }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFE2E8F0))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Icon(
                painter = painterResource(R.drawable.clock),
                contentDescription = "Clock",
                tint = Color.Gray,
                modifier = Modifier.size(25.dp)
            )

            Column(modifier = Modifier.padding(10.dp).weight(1f)) {

                Text("Daily focus reminder", maxLines = 1)

                Spacer(modifier = Modifier.height(5.dp))

                Text("Ever Morning at 9:00 AM", maxLines = 1)
            }

            Spacer(modifier = Modifier.width(90.dp))

            androidx.compose.material3.Switch(modifier = Modifier.padding(end = 10.dp),
                checked = isEnabled,
                onCheckedChange = { isEnabled = it },
                colors = SwitchColors(
                    Color.White,
                    uncheckedTrackColor = Color.LightGray,
                    uncheckedThumbColor = Color.White,
                    uncheckedBorderColor = Color.LightGray,
                    uncheckedIconColor = Color.LightGray,
                    checkedTrackColor = Appdefault,
                    checkedBorderColor = Color.Unspecified,
                    checkedIconColor = Color.Unspecified,
                    disabledCheckedThumbColor = Color.Unspecified,
                    disabledCheckedTrackColor = Color.Unspecified,
                    disabledCheckedBorderColor = Color.Unspecified,
                    disabledCheckedIconColor = Color.Unspecified,
                    disabledUncheckedThumbColor = Color.Unspecified,
                    disabledUncheckedTrackColor = Color.Unspecified,
                    disabledUncheckedBorderColor = Color.Unspecified,
                    disabledUncheckedIconColor = Color.Unspecified
                )
            )


        }

        HorizontalDivider(
            thickness = 1.dp,
            color = Color.LightGray
//                .copy(alpha = 0.25f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.vibrate),
                contentDescription = "Phone Vibrate",
                tint = Color.Gray,
                modifier = Modifier.size(25.dp)
            )

            Column(modifier = Modifier.padding(10.dp).weight(1f)) {

                Text("Haptic feedback", maxLines = 1)

                Spacer(modifier = Modifier.height(5.dp))

                Text("Vibrate when a task is completed", maxLines = 1)
            }

            Spacer(modifier = Modifier.width(40.dp))

            androidx.compose.material3.Switch(modifier = Modifier.padding(end = 10.dp),
                checked = isFeedBack,
                onCheckedChange = { isFeedBack = it },
                colors = SwitchColors(
                    Color.White,
                    uncheckedTrackColor = Color.LightGray,
                    uncheckedThumbColor = Color.White,
                    uncheckedBorderColor = Color.LightGray,
                    uncheckedIconColor = Color.LightGray,
                    checkedTrackColor = Appdefault,
                    checkedBorderColor = Color.Unspecified,
                    checkedIconColor = Color.Unspecified,
                    disabledCheckedThumbColor = Color.Unspecified,
                    disabledCheckedTrackColor = Color.Unspecified,
                    disabledCheckedBorderColor = Color.Unspecified,
                    disabledCheckedIconColor = Color.Unspecified,
                    disabledUncheckedThumbColor = Color.Unspecified,
                    disabledUncheckedTrackColor = Color.Unspecified,
                    disabledUncheckedBorderColor = Color.Unspecified,
                    disabledUncheckedIconColor = Color.Unspecified
                )
            )
        }
    }

}