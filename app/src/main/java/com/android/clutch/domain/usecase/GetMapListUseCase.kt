package com.android.clutch.domain.usecase

import com.android.clutch.data.ValorantRepository

class GetMapListUseCase(
    private val valorantRepository: ValorantRepository
) {
    suspend fun invoke() = valorantRepository.getMapList()
}