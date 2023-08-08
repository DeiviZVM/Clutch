package com.android.clutch.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.clutch.presentation.home.HomeScreen
import com.android.clutch.presentation.home.MainScreen
import com.android.clutch.presentation.login.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController) {
    composable(Screen.LoginScreen.route) {
        LoginScreen(
            onForgotClicked = {
                navController.navigate(Screen.ForgotPasswordScreen.route)
            },
            onLoginSuccess = {
                navController.navigate(Screen.MainScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addHomeScreen() {
    composable(Screen.HomeScreen.route) {
        HomeScreen()
    }
}

fun NavGraphBuilder.addMainScreen() {
    composable(Screen.MainScreen.route) {
        MainScreen()
    }
}

