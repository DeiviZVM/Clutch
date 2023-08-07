package com.android.clutch.data.remote.dto

import com.squareup.moshi.Json

data class AgentDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "portrait_url") val portraitUrl: String?,
    @Json(name = "videogame_versions") val gameVersion: String?
)