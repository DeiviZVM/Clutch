package com.android.clutch.presentation.home.agentsList

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.clutch.AgentTestDataBuilder
import com.android.clutch.R
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.presentation.theme.backgroundColor

@Composable
fun ShowAgentList(
    agent: AgentModel,
    onclick: () -> Unit
) {

    Surface(
        shape = MaterialTheme.shapes.small,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(agent.portraitUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.agent_killjoy),
                error = painterResource(id = R.drawable.agent_killjoy),
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape).background(Color.LightGray),

                )
            Text(
                text = agent.name,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
@Preview
fun ShowAgentPreview() {
    AgentTestDataBuilder()
        .withName("Killjoy")
        .withPortraitUrl("https://cdn.pandascore.co/images/valorant/agent/image/252/killjoy_icon-png-png-png-png-png-png-png-png")
        .buildSingle()
}

