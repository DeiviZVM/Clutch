package com.android.clutch.presentation.home.teams

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.clutch.R
import com.android.clutch.components.FavoriteComponent
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.model.TeamModel

@Composable
fun ShowTeamList(
    team: TeamModel,
    onClick: () -> Unit
) {

    var starred by rememberSaveable {
        mutableStateOf(false)
    }

    Surface(
        border = BorderStroke(2.dp, Color.LightGray),
        shape = MaterialTheme.shapes.small,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                }
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(team.imageUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.teams),
                error = painterResource(id = R.drawable.teams),
                modifier = Modifier
                    .size(80.dp)
                    .padding(15.dp)

            )

            Column {

                Row {

                    Text(
                        text = "Acrónimo : ",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .padding()
                    )

                    Text(
                        text = team.acronym,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .padding()
                    )
                }

                Row {

                    Text(
                        text = "Nombre : ",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .padding()
                    )

                    Text(
                        text = team.name,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .padding()
                    )
                }

                Row {

                    Text(
                        text = "Localización : ",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .padding()
                    )

                    Text(
                        text = team.location,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier
                            .padding()
                    )
                }
            }
        }
    }
}