package com.android.clutch.data.remote

import com.android.clutch.data.remote.dto.AgentDto

class RemoteDataSourceImpl(private val valorantApi: ValorantApi) : RemoteDataSource {
    override suspend fun getAgentList(): List<AgentDto> =
        valorantApi.getAgentList()
}