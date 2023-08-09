package com.android.clutch.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.clutch.data.local.model.AgentLocal
import com.android.clutch.domain.model.AgentModel

@Dao
interface AgentDao {

    @Query("SELECT * FROM AgentTable")
    suspend fun getAll(): List<AgentLocal>

    @Query("SELECT * FROM AgentTable WHERE id=:id")
    suspend fun getAgentById(id: String) : AgentModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<AgentLocal>)
}