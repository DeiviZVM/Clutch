package com.android.clutch.presentation.home.teams

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.clutch.components.ShowError
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

    Column(modifier = Modifier.fillMaxHeight()) {

        LazyColumn(
            contentPadding = PaddingValues(16.dp, 24.dp, 16.dp, 70.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            item {
                Text(
                    text = "Equipos".uppercase(),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
            }

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