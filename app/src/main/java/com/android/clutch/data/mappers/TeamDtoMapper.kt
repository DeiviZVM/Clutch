package com.android.clutch.data.mappers

import com.android.clutch.data.remote.dto.TeamDto
import com.android.clutch.domain.model.TeamModel

fun TeamDto.toTeamModel() = TeamModel(
    id = id ?: 0,
    name = name ?: "",
    players = players ?: listOf()
)