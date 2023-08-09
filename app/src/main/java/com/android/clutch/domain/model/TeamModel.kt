package com.android.clutch.domain.model

import com.android.clutch.data.remote.dto.PlayerDto

data class TeamModel (
    val acronym: String,
    val id: Int,
    val imageUrl: String,
    val location: String,
    val name: String,
    val players: List<PlayerDto>
)