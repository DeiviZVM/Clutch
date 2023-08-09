package com.android.clutch.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.clutch.data.local.model.AgentLocal
import com.android.clutch.data.local.model.TeamLocal

@Dao
interface TeamDao {

    @Query("SELECT * FROM TeamTable")
    suspend fun getAllTeams(): List<TeamLocal>

    @Query("SELECT * FROM TeamTable WHERE id=:id")
    suspend fun getTeamById(id: Int) : TeamLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<TeamLocal>)

}