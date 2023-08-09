package com.android.clutch.presentation.home.detail

import android.annotation.SuppressLint
import android.util.Log
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
fun TeamDetailScreen(
    id: Int,
    teamDetailViewModel: DetailViewModel = koinViewModel(),
    onBack: () -> Unit
){

    Log.d("DETAIL", id.toString())

    val teamState = teamDetailViewModel.team.observeAsState()
    val errorState = teamDetailViewModel.errorMessage.observeAsState()

    teamDetailViewModel.getTeam(id)

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    val result = teamState.value

    result?.let { team ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Detalle de ${ team.name }")
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
            ShowTeamDetail(team = team)
        }
    } ?: run {
        ShowError("Unknown error")
    }

}