package com.android.clutch.di

import com.android.clutch.domain.usecase.GetAgentListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetAgentListUseCase(get()) }
}