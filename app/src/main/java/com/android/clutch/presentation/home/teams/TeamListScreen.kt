package com.android.clutch.presentation.home.teams

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
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
    teamListViewModel: TeamListViewModel = koinViewModel(),
    onItemClick: (Int) -> Unit
) {
    val state = teamListViewModel.teamList.observeAsState()

    val errorState = teamListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    //TODO - Arreglar titulo que aparece debajo del listado

    Text(
        text = "Equipos".uppercase(),
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    )

    Column(modifier = Modifier.fillMaxHeight()) {

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 70.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val teamList = state.value
            items(teamList?.size ?: 0) { i ->
                val item = teamList?.get(i)
                item?.let { team ->
                    ShowTeamList(team) {
                        onItemClick.invoke(team.id)
                    }
                }
            }
        }
    }


}