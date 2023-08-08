package com.android.clutch.data.local

import com.android.clutch.data.local.model.AgentLocal

class LocalDataSourceImpl(
    private val agentDao: AgentDao
) : LocalDataSource {
    override suspend fun getAgentList(): List<AgentLocal> = agentDao.getAll()
    override suspend fun insertAgentList(agentList: List<AgentLocal>) = agentDao.insertAll(agentList)
}