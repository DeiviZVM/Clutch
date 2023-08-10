package com.android.clutch.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.android.clutch.presentation.bottomBar.BottomBarScreen
import com.android.clutch.presentation.home.HomeScreen
import com.android.clutch.presentation.home.detail.TeamDetailScreen
import com.android.clutch.presentation.home.teams.TeamListScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }

        composable(route = BottomBarScreen.Teams.route) {
            TeamListScreen(
                onItemClick = { teamId ->
                    navController.navigate("${DetailsScreen.TeamDetail.route}/$teamId")
                }
            )
        }
        detailsNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController){
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.TeamDetail.route
    ){
        composable(
            route = DetailsScreen.TeamDetail.route + "/{teamId}",
            arguments = DetailsScreen.TeamDetail.arguments
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("teamId") ?: 0
            TeamDetailScreen(id = id) {
                navController.popBackStack()
            }
        }
    }
}

sealed class DetailsScreen(val route: String, val arguments: List<NamedNavArgument>) {
    object TeamDetail : DetailsScreen(
        route = "TEAMDETAIL",
        arguments = listOf(
            navArgument("teamId") {
                type = NavType.IntType
                nullable = false
            }
        )
    )
}