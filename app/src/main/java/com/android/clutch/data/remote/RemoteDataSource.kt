package com.android.clutch.data.remote

import com.android.clutch.data.remote.dto.AgentDto

interface RemoteDataSource {
    suspend fun getAgentList(): List<AgentDto>
}