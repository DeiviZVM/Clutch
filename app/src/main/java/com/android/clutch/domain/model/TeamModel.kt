package com.android.clutch.domain.model

import com.android.clutch.data.remote.dto.PlayerDto

data class TeamModel (
    val id: Int,
    val name: String,
    val players: List<PlayerDto>
)