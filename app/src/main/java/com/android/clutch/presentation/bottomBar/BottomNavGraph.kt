package com.android.clutch.presentation.bottomBar

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.clutch.navigation.Graph
import com.android.clutch.navigation.NavigationGraph
import com.android.clutch.navigation.Screen
import com.android.clutch.navigation.Screen.ForgotPasswordScreen.arguments
import com.android.clutch.navigation.addTeamDetailScreen
import com.android.clutch.presentation.home.HomeScreen
import com.android.clutch.presentation.home.detail.TeamDetailScreen
import com.android.clutch.presentation.home.teams.TeamListScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.Menu,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }

        composable(route = BottomBarScreen.Teams.route) {
            TeamListScreen { teamId ->

            }
        }
    }
}