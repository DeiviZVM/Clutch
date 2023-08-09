package com.android.clutch.domain.usecase

import com.android.clutch.data.ValorantRepository
import com.android.clutch.domain.model.AgentModel

class GetDetailUseCase(
    private val valorantRepository: ValorantRepository
){
    suspend fun invoke(id: String): AgentModel = valorantRepository.getAgentById(id)
}