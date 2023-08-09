package com.android.clutch.data

import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.model.MapModel
import com.android.clutch.domain.model.TeamModel

interface ValorantRepository {

    suspend fun getAgentList(): List<AgentModel>
    suspend fun getAgentById(id: String) : AgentModel
    suspend fun getMapList(): List<MapModel>
    suspend fun getTeamList(): List<TeamModel>
}