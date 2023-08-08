package com.android.clutch.presentation.home.agentsList

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.clutch.components.ShowError
import com.android.clutch.components.DrawableStringPair
import org.koin.androidx.compose.koinViewModel


@Composable
fun AgentListScreen(
    agentListViewModel: AgentListViewModel = koinViewModel(),
) {
    val state = agentListViewModel.agentList.observeAsState()

    val errorState = agentListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val agentList = state.value
        items(agentList?.size ?: 0) { i ->
            val item = agentList?.get(i)
            item?.let { agent ->
                ShowAgentList(agent) {

                }
            }
        }
    }
}


