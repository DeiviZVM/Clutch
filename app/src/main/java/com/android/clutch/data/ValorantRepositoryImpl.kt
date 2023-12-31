package com.android.clutch.data

import com.android.clutch.data.local.LocalDataSource
import com.android.clutch.data.mappers.toAgentLocal
import com.android.clutch.data.mappers.toAgentModel
import com.android.clutch.data.mappers.toMapModel
import com.android.clutch.data.mappers.toTeamLocal
import com.android.clutch.data.mappers.toTeamModel
import com.android.clutch.data.remote.RemoteDataSource
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.model.MapModel
import com.android.clutch.domain.model.TeamModel

class ValorantRepositoryImpl (
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ValorantRepository {

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

    override suspend fun getTeamList(): List<TeamModel> {
        val localData = localDataSource.getTeamList()

        return if (localData.isNotEmpty()) {
            localData.map { it.toTeamModel() }
        } else {
            val remoteData = remoteDataSource.getTeamList().filter {
                (it.name?.isNotEmpty() == true)
            }
            localDataSource.insertTeamList(remoteData.map { it.toTeamLocal() })

            remoteData.map {
                it.toTeamModel()
            }
        }

    }

    override suspend fun getTeamById(id: Int): TeamModel =
        localDataSource.getTeamById(id).toTeamModel()

    }



