package com.android.clutch.presentation.home.mapsList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.clutch.R
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.model.MapModel
import com.android.clutch.presentation.home.agentsList.AgentListViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner

@Composable
fun ShowMapList(
    map: MapModel
){
    Surface(
        shape = MaterialTheme.shapes.small,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(map.imageUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.map_ascend),
                error = painterResource(id = R.drawable.map_ascend),
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape),

                )
            Text(
                text = map.name,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
            )
        }
    }
}