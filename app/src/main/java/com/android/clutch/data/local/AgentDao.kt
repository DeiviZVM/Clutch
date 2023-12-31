package com.android.clutch.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.clutch.data.local.model.AgentLocal
import com.android.clutch.data.local.model.TeamLocal
import com.android.clutch.domain.model.AgentModel

@Dao
interface AgentDao {

    @Query("SELECT * FROM AgentTable")
    suspend fun getAll(): List<AgentLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<AgentLocal>)
}