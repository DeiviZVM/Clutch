package com.android.clutch.domain.usecase

import com.android.clutch.data.AgentRepository

class GetMapListUseCase(
    private val agentRepository: AgentRepository
) {
    suspend fun invoke() = agentRepository.getMapList()
}