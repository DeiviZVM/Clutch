package com.android.clutch.presentation.home.detail

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.android.clutch.components.ShowError
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AgentDetailScreen(
    id: String,
    agentDetailViewModel: DetailViewModel = koinViewModel(),
    onBack: () -> Unit
){

    val agentState = agentDetailViewModel.agent.observeAsState()
    val errorState = agentDetailViewModel.errorMessage.observeAsState()

    agentDetailViewModel.getAgent(id)

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    val result = agentState.value

    result?.let { agent ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Detalle de ${ agent.name }")
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier.semantics {
                                contentDescription = "Atrás Botón Ir al listado de personajes"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            }
        ) {
            ShowAgentDetail(agent = agent)
        }
    } ?: run {
        ShowError("Unknown error")
    }

}