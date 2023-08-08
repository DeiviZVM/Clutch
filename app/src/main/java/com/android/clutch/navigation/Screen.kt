package com.android.clutch.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {

    object LoginScreen : Screen(
        route = "login",
        arguments = emptyList()
    )

    object ForgotPasswordScreen : Screen(
        route = "forgotPassword",
        arguments = emptyList()
    )

    object HomeScreen : Screen(
        route = "home",
        arguments = emptyList()
    )
}