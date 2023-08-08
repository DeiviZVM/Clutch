package com.android.clutch.data.remote

import com.android.clutch.BuildConfig
import com.android.clutch.data.remote.dto.AgentDto
import com.android.clutch.data.remote.dto.MapDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

const val TOKEN: String = BuildConfig.TOKEN

interface ValorantApi {

    @GET("agents")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getAgentList(): List<AgentDto>

    @GET("maps")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getMapsList(): List<MapDto>
}