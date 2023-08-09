package com.android.clutch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.android.clutch.navigation.NavigationGraph
import com.android.clutch.presentation.theme.ClutchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ClutchTheme(dynamicColor = false) {
                NavigationGraph()
            }
        }
    }
}

