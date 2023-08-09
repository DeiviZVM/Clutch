package com.android.clutch.data.remote

import com.android.clutch.data.remote.dto.AgentDto
import com.android.clutch.data.remote.dto.MapDto
import com.android.clutch.data.remote.dto.TeamDto

interface RemoteDataSource {
    suspend fun getAgentList(): List<AgentDto>
    suspend fun getMapsList(): List<MapDto>
    suspend fun getTeamList(): List<TeamDto>
}