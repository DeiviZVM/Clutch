package com.android.clutch.data

import com.android.clutch.data.local.LocalDataSource
import com.android.clutch.data.mappers.toAgentLocal
import com.android.clutch.data.mappers.toAgentModel
import com.android.clutch.data.mappers.toMapModel
import com.android.clutch.data.remote.RemoteDataSource
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.model.MapModel

class AgentRepositoryImpl (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : AgentRepository {

    override suspend fun getAgentList(): List<AgentModel> {
       val localData = localDataSource.getAgentList()

        return if (localData.isNotEmpty()) {
            localData.map { it.toAgentModel() }
        } else {
            val remoteData = remoteDataSource.getAgentList().filter {
                (it.name?.isNotEmpty() == true)
            }
            localDataSource.insertAgentList(remoteData.map { it.toAgentLocal() })

            remoteData.map {
                it.toAgentModel()
            }
        }
    }

    override suspend fun getMapList(): List<MapModel> =
        remoteDataSource.getMapsList().map { it.toMapModel() }
    }
