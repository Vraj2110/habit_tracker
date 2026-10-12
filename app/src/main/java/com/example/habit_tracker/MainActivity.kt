package com.example.habit_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.habit_tracker.ui.theme.Habit_TrackerTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen  = InstallSplashScreen()
        super.onCreate(savedInstanceState)

        // Optional: Keep the splash screen visible while loading initial data (e.g., checking local habits database)
        // Set this to `false` when your data is ready.
        var isDataLoaded = false
        splashScreen.setKeepOnScreenCondition {
            !isDataLoaded
        }

        // Simulate a short delay for data loading (Remove this in production if data loads instantly)
        lifecycle.launch{
            delay(1500)
            isDataLoaded = true
        }

        setContent {
            Habit_TrackerTheme(){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 2. Set up your Jetpack Compose Navigation
                    HabitNavGraph()
                }
            }
        }
    }
    }