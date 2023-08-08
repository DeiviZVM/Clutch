package com.android.clutch.data.remote

import com.android.clutch.data.remote.dto.AgentDto
import com.android.clutch.data.remote.dto.MapDto

interface RemoteDataSource {
    suspend fun getAgentList(): List<AgentDto>
    suspend fun getMapsList(): List<MapDto>
}