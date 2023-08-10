package com.android.clutch.di

import com.android.clutch.presentation.home.agentsList.AgentListViewModel
import com.android.clutch.presentation.home.teamDetail.DetailViewModel
import com.android.clutch.presentation.home.mapsList.MapListViewModel
import com.android.clutch.presentation.home.teams.TeamListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { AgentListViewModel(get()) }
    viewModel { MapListViewModel(get()) }
    viewModel { TeamListViewModel(get())}
    viewModel { DetailViewModel(get()) }
}