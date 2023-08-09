package com.android.clutch.data.remote.dto

import com.squareup.moshi.Json

data class TeamDto(
    @Json(name = "acronym") val acronym: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "image_url") val imageUrl: String?,
    @Json(name = "location") val location: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "players") val players: List<PlayerDto>?
)
