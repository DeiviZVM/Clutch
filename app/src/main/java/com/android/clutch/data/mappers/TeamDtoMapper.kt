package com.android.clutch.data.mappers

import com.android.clutch.data.local.model.TeamLocal
import com.android.clutch.data.remote.dto.TeamDto
import com.android.clutch.domain.model.TeamModel

fun TeamDto.toTeamModel() = TeamModel(
    acronym = acronym ?: "Ninguno",
    id = id ?: 0,
    imageUrl = imageUrl ?: "",
    location = location ?: "Desconocida",
    name = name ?: "",
    //players = players ?: listOf()
)

fun TeamDto.toTeamLocal() = TeamLocal(
    acronym = acronym ?: "Ninguno",
    id = id ?: 0,
    imageUrl = imageUrl ?: "",
    location = location ?: "Desconocida",
    name = name ?: "",
    //players = players ?: listOf()
)

fun TeamLocal.toTeamModel() = TeamModel(
    acronym = acronym,
    id = id,
    imageUrl = imageUrl,
    location = location,
    name = name,
    //players = players
)