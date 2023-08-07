package com.android.clutch.data.local

import com.android.clutch.data.local.model.AgentLocal

interface LocalDataSource {
    suspend fun getAgentList(): List<AgentLocal>
    suspend fun insertAgentList(agentList: List<AgentLocal>)
}