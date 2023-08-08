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
import com.android.clutch.components.DrawableStringPair
import com.android.clutch.components.ShowError
import com.android.clutch.domain.model.MapModel
import com.android.clutch.presentation.home.agentsList.AgentListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MapListScreen(
    mapListViewModel: MapListViewModel = koinViewModel()
){
    val state = mapListViewModel.mapList.observeAsState()
    val errorState = mapListViewModel.errorMessage.observeAsState()

    if(errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.width(120.dp)
    ) {
        val mapList = state.value
        items(mapList?.size ?: 0) {i ->
            val item = mapList?.get(i)
            item?.let { map ->
                ShowMapList(map)
            }
        }
    }
}

/*
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun MapCardPreview() {
    MapCard(
        drawable = com.android.clutch.R.drawable.map_pearl,
        text = com.android.clutch.R.string.map_pearl,
        Modifier.padding(8.dp)
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun MapListPreview() {
    MapList()
}



private val mapData = listOf(
    com.android.clutch.R.drawable.map_ascend to com.android.clutch.R.string.map_ascent,
    com.android.clutch.R.drawable.map_bind to com.android.clutch.R.string.map_bind,
    com.android.clutch.R.drawable.map_breeze to com.android.clutch.R.string.map_breeze,
    com.android.clutch.R.drawable.map_fracture to com.android.clutch.R.string.map_fracture,
    com.android.clutch.R.drawable.map_haven to com.android.clutch.R.string.map_haven,
    com.android.clutch.R.drawable.map_icebox to com.android.clutch.R.string.map_icebox,
    com.android.clutch.R.drawable.map_lotus to com.android.clutch.R.string.map_lotus,
    com.android.clutch.R.drawable.map_pearl to com.android.clutch.R.string.map_pearl,
    com.android.clutch.R.drawable.map_split to com.android.clutch.R.string.map_split
).map { DrawableStringPair(it.first, it.second) }


 */
