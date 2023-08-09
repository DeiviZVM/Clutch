package com.android.clutch.data.mappers

import com.android.clutch.data.remote.dto.TeamDto
import com.android.clutch.domain.model.TeamModel

fun TeamDto.toTeamModel() = TeamModel(
    acronym = acronym ?: "Ninguno",
    id = id ?: 0,
    imageUrl = imageUrl ?: "",
    location = location ?: "Desconocida",
    name = name ?: "",
    players = players ?: listOf()
)