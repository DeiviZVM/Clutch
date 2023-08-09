package com.android.clutch.data.local

import com.android.clutch.data.local.model.AgentLocal
import com.android.clutch.domain.model.AgentModel

interface LocalDataSource {
    suspend fun getAgentList(): List<AgentLocal>
    suspend fun insertAgentList(agentList: List<AgentLocal>)
    suspend fun getAgentById(id: String): AgentModel
}