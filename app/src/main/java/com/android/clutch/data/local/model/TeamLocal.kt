package com.android.clutch.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.android.clutch.data.remote.dto.PlayerDto

@Entity(tableName = "TeamTable")
data class TeamLocal (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "acronym") val acronym: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "location") val location: String,
    @ColumnInfo(name = "name") val name: String,
    //@ColumnInfo(name = "players") val players: List<PlayerDto>,
)
