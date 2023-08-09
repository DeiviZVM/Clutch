package com.android.clutch.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.android.clutch.presentation.bottomBar.MainScreen
import com.android.clutch.presentation.home.detail.AgentDetailScreen
import com.android.clutch.presentation.login.LoginScreen
import com.android.clutch.presentation.login.NewLoginScreen

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

fun NavGraphBuilder.addNewLoginScreen(navController: NavController) {
    composable(Screen.NewLoginScreen.route) {
        NewLoginScreen(
            onLoginSuccess = {
                navController.navigate(Screen.MainScreen.route)
            }
        )
    }
}

fun NavGraphBuilder.addAgentDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.AgentDetailScreen.route + "/{agentId}",
        arguments = Screen.AgentDetailScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("agentId") ?: ""
        AgentDetailScreen(id = id) {
            navController.popBackStack()
        }
    }
}

fun NavGraphBuilder.addMainScreen() {
    composable(Screen.MainScreen.route) {
        MainScreen()
    }
}

