package com.android.clutch.domain.usecase

import com.android.clutch.data.AgentRepository

class GetAgentListUseCase(private val agentRepository: AgentRepository) {
    suspend fun invoke() = agentRepository.getAgentList()
}