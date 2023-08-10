package com.android.clutch.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.android.clutch.presentation.login.NewLoginScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        route = Graph.LOGIN,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route) {
            NewLoginScreen (
                onLoginSuccess = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "LOGIN")
}