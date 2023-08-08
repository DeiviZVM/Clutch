package com.android.clutch.data.remote.dto

import com.squareup.moshi.Json

data class MapDto(
    @Json(name = "id") var id: Int? = null,
    @Json(name = "image_url") var imageUrl: String? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "videogame_versions") var videogameVersions: ArrayList<String> = arrayListOf()
)