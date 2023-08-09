package com.android.clutch.di

import com.android.clutch.domain.usecase.GetAgentListUseCase
import com.android.clutch.domain.usecase.GetDetailUseCase
import com.android.clutch.domain.usecase.GetMapListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetAgentListUseCase(get()) }
    single { GetDetailUseCase(get()) }
    single { GetMapListUseCase(get()) }
}