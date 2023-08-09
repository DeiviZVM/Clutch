package com.android.clutch.presentation.home.teams

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.clutch.components.ShowError
import com.android.clutch.presentation.home.agentsList.ShowAgentList
import org.koin.androidx.compose.koinViewModel

@Composable
fun TeamListScreen(
    teamListViewModel: TeamListViewModel = koinViewModel()
) {
    val state = teamListViewModel.teamList.observeAsState()

    val errorState = teamListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val teamList = state.value
        items(teamList?.size ?: 0) { i ->
            val item = teamList?.get(i)
            item?.let { team ->
                ShowTeamList(team) {

                }
            }
        }
    }
}