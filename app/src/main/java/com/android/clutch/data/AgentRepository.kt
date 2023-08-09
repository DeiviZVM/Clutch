package com.android.clutch.data

import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.model.MapModel

interface AgentRepository {

    suspend fun getAgentList(): List<AgentModel>
    suspend fun getAgentById(id: String) : AgentModel
    suspend fun getMapList(): List<MapModel>
}