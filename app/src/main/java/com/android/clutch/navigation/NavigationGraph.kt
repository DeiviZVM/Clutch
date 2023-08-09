package com.android.clutch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost( // FragmentContainerView
        navController = navController,
        startDestination = Screen.NewLoginScreen.route ,
    ) {
        addNewLoginScreen(navController)
        addMainScreen()
        addAgentDetailScreen(navController)
        addLoginScreen(navController)
    }
}