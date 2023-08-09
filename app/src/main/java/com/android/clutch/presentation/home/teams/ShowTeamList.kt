package com.android.clutch.presentation.home.teams

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
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
        shape = MaterialTheme.shapes.small,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {



            Text(
                text = team.name,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
            )
        }
    }
}