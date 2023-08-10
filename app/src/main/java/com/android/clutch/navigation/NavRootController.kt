package com.android.clutch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavRootController(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        route = Graph.Root,
        startDestination = Graph.Main
    ){

    }
}

object Graph {
    const val Root = "main_root"
    const val Main = "main_graph"
    const val Menu = "menu_graph"
}