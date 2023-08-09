package com.android.clutch.data.remote

import com.android.clutch.data.remote.dto.AgentDto
import com.android.clutch.data.remote.dto.MapDto
import com.android.clutch.data.remote.dto.SearchDto

class RemoteDataSourceImpl(
    private val valorantApi: ValorantApi
) : RemoteDataSource {
    override suspend fun getAgentList(): List<AgentDto> =
        valorantApi.getAgentList()

    override suspend fun getMapsList(): List<MapDto> =
        valorantApi.getMapsList()
}