package com.android.clutch.domain.usecase

import com.android.clutch.data.AgentRepository
import com.android.clutch.domain.model.AgentModel

class GetDetailUseCase(
    private val agentRepository: AgentRepository
){
    suspend fun invoke(id: String): AgentModel = agentRepository.getAgentById(id)
}