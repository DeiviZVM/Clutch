package com.android.clutch.presentation.home.teamDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.clutch.R
import com.android.clutch.domain.model.TeamModel
import com.android.clutch.presentation.theme.backgroundColor
import kotlinx.coroutines.job

val requester = FocusRequester()

@Composable
fun ShowTeamDetail(
    team: TeamModel
) {

    Card(
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = contentColorFor(backgroundColor),
        shape = MaterialTheme.shapes.medium,
        elevation = 10.dp,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp)
    ) {
        Column(

        ) {

            AsyncImage(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .fillMaxWidth()
                    .focusRequester(focusRequester = requester)
                    .focusable(),
                placeholder = painterResource(id = R.drawable.teams),
                error = painterResource(id = R.drawable.teams),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(team.imageUrl)
                    .build(),
                contentDescription = "Imagen del equipo ${team.name}"
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .background(color = Color.LightGray, shape = CircleShape)
                        .size(40.dp),
                    contentAlignment = Alignment.Center
                ) {

                    AsyncImage(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .focusRequester(focusRequester = requester)
                            .focusable(),
                        placeholder = painterResource(id = R.drawable.teams),
                        error = painterResource(id = R.drawable.teams),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(team.imageUrl)
                            .build(),
                        contentDescription = "Imagen del equipo ${team.name}"
                    )

                }

                Spacer(modifier = Modifier.width(32.dp))

                Column() {
                    // Encabezado
                    Text(
                        text = "${team.name} ${ if(team.acronym != "Ninguno") { " - ${team.acronym}" } else {""}}  ",
                        style = MaterialTheme.typography.h6
                    )

                    // Subtítulo
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            text = team.location,
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
            }
        }
    }

}