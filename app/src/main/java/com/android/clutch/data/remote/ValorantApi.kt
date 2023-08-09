package com.android.clutch.data.remote

import com.android.clutch.BuildConfig
import com.android.clutch.data.remote.dto.AgentDto
import com.android.clutch.data.remote.dto.MapDto
import com.android.clutch.data.remote.dto.TeamDto
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

    @GET("teams")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getTeamsList(): List<TeamDto>
}