package com.android.clutch.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object NewLoginScreen: Screen(
        route = "newLogin",
        arguments = emptyList()
    )

    object LoginScreen : Screen(
        route = "login",
        arguments = emptyList()
    )

    object ForgotPasswordScreen : Screen(
        route = "forgotPassword",
        arguments = emptyList()
    )

    object TeamListScreen: Screen(
        route = "teamList",
        arguments = emptyList()
    )

    object TeamDetailScreen : Screen(
        route = "teamDetail",
        arguments = listOf(
            navArgument("teamId") {
                type = NavType.IntType
                nullable = false
            }
        )
    )

    object MainScreen : Screen(
        route = "main",
        arguments = emptyList()
    )
}