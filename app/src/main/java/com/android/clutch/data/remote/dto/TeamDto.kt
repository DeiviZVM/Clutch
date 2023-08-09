package com.android.clutch.data.remote.dto

import com.squareup.moshi.Json

data class TeamDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "players") val players: List<PlayerDto>?
)
