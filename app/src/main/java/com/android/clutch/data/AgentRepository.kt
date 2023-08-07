package com.android.clutch.data

import com.android.clutch.domain.model.AgentModel

interface AgentRepository {

    suspend fun getAgentList(): List<AgentModel>
}