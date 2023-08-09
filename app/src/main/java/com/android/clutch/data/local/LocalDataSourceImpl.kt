package com.android.clutch.data.local

import com.android.clutch.data.local.model.AgentLocal
import com.android.clutch.data.local.model.TeamLocal
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.model.TeamModel

class LocalDataSourceImpl(
    private val agentDao: AgentDao,
    private val teamDao: TeamDao
) : LocalDataSource {
    override suspend fun getAgentList(): List<AgentLocal> = agentDao.getAll()
    override suspend fun insertAgentList(agentList: List<AgentLocal>) = agentDao.insertAll(agentList)
    override suspend fun getTeamList(): List<TeamLocal> = teamDao.getAllTeams()
    override suspend fun insertTeamList(teamList: List<TeamLocal>) = teamDao.insertAll(teamList)
    override suspend fun getTeamById(id: Int): TeamLocal = teamDao.getTeamById(id)
}