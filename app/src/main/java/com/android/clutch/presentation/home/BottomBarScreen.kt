package com.android.clutch.presentation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val arguments: List<NamedNavArgument>,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = "HOME",
        arguments = listOf() ,
        icon = Icons.Default.Home
    )

    object Teams : BottomBarScreen(
        route = "TEAMS",
        title = "TEAMS",
        icon = Icons.Default.Person,
        arguments = listOf(
        navArgument("heroId") {
            type = NavType.IntType
            nullable = false
        }
        )
    )
}