package com.android.clutch.data.mappers

import com.android.clutch.data.remote.dto.MapDto
import com.android.clutch.domain.model.MapModel
import java.nio.channels.FileChannel.MapMode

fun MapDto.toMapModel() = MapModel(
    id = id ?: 0,
    name = name ?: "",
    imageUrl = imageUrl ?: ""
)