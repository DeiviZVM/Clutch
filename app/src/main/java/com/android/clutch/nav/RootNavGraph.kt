package com.android.clutch.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.clutch.presentation.bottomBar.NavScreen
import com.android.clutch.presentation.home.HomeScreen

@Composable
fun RootNavigationGraph(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.LOGIN
    ){
        authNavGraph(navController = navHostController)
        composable(route = Graph.HOME) {
            NavScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val LOGIN = "login_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}