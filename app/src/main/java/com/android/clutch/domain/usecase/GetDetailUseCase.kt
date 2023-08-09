package com.android.clutch.domain.usecase

import com.android.clutch.data.ValorantRepository
import com.android.clutch.domain.model.AgentModel
import com.android.clutch.domain.model.TeamModel

class GetDetailUseCase(
    private val valorantRepository: ValorantRepository
){
    //TODO repository -> Team de la Base de Datos por Id
    //suspend fun invoke(id: String): TeamModel = valorantRepository.getTeamList(id)
}