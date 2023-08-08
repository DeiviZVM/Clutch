package com.android.clutch.data.mappers

import com.android.clutch.data.local.model.AgentLocal
import com.android.clutch.data.remote.dto.AgentDto
import com.android.clutch.domain.model.AgentModel

fun AgentDto.toAgentModel() = AgentModel(
    id = id ?: 0,
    name = name ?: "",
    portraitUrl = portraitUrl ?: ""
)

fun AgentDto.toAgentLocal() = AgentLocal(
    id = id ?: 0,
    name = name ?: "",
    portraitUrl = portraitUrl ?: ""
)

fun AgentLocal.toAgentModel() = AgentModel(
    id = id,
    name = name,
    portraitUrl = portraitUrl
)