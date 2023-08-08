package com.android.clutch.presentation.home

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.android.clutch.R
import com.android.clutch.navigation.Screen
import com.android.clutch.presentation.bottomBar.BottomBarScreen
import com.android.clutch.presentation.bottomBar.BottomNavGraph
import com.android.clutch.presentation.home.agentsList.AgentListScreen
import com.android.clutch.presentation.home.agentsList.AgentListViewModel
import com.android.clutch.presentation.home.mapsList.MapListScreen
import com.android.clutch.presentation.home.mapsList.MapListViewModel
import com.android.clutch.presentation.home.searchBar.SearchBar
import com.android.clutch.presentation.theme.ClutchTheme
import org.koin.androidx.compose.koinViewModel
import java.util.Locale

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Column(modifier) {
        Text(
            stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 18.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun HomeScreen(
    agentListViewModel: AgentListViewModel = koinViewModel(),
    mapListViewModel: MapListViewModel = koinViewModel(),
) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.title_agents) {
            AgentListScreen(agentListViewModel)
        }
        HomeSection(title = R.string.title_maps) {
            MapListScreen(mapListViewModel)
        }
        Spacer(Modifier.height(16.dp))
    }

}