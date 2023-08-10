package com.android.clutch.presentation.home.teamDetail

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.clutch.R
import com.android.clutch.domain.model.TeamModel
import kotlinx.coroutines.job

val requester = FocusRequester()

@Composable
fun ShowTeamDetail(
    team: TeamModel
) {

    var starred by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .focusRequester(focusRequester = requester)
                .focusable(),
            placeholder = painterResource(id = R.drawable.agent_killjoy),
            error = painterResource(id = R.drawable.agent_killjoy),
            model = ImageRequest.Builder(LocalContext.current)
                .data(team.imageUrl)
                .build(),
            contentDescription = "Personaje ${team.name} Imagen"
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = team.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Star
            // Gestionar la semántica y los cambios de estado
            Checkbox(
                modifier = Modifier
                    .clearAndSetSemantics {
                        //.semantics {
                        contentDescription = "Hacer ${team.name} Favorito"
                        stateDescription = if (starred) {
                            "${team.name} marcado como Favorito"
                        } else {
                            "${team.name} desmarcado como Favorito"
                        }
                    },
                checked = starred,
                onCheckedChange = {
                    starred = it
                }
            )
        }

        LaunchedEffect(Unit) {
            this.coroutineContext.job.invokeOnCompletion {
                requester.requestFocus()
            }
        }
    }

}