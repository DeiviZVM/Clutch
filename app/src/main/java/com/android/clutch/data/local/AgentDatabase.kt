package com.android.clutch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.clutch.data.local.model.AgentLocal

@Database(entities = [AgentLocal::class], version = 1, exportSchema = false)
abstract class AgentDatabase : RoomDatabase() {
    abstract fun getAgentDao() : AgentDao
}