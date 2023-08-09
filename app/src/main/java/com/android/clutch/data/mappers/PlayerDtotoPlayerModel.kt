package com.android.clutch.data.mappers

import com.android.clutch.data.remote.dto.PlayerDto
import com.android.clutch.domain.model.PlayerModel

fun PlayerDto.toPlayerModel() = PlayerModel(
    id = id ?: 0,
    name = name ?: ""
)