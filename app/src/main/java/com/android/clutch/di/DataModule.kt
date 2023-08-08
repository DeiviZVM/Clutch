package com.android.clutch.di

import android.content.Context
import androidx.room.Room
import com.android.clutch.BuildConfig
import com.android.clutch.data.AgentRepository
import com.android.clutch.data.AgentRepositoryImpl
import com.android.clutch.data.local.AgentDao
import com.android.clutch.data.local.AgentDatabase
import com.android.clutch.data.local.LocalDataSource
import com.android.clutch.data.local.LocalDataSourceImpl
import com.android.clutch.data.remote.RemoteDataSource
import com.android.clutch.data.remote.RemoteDataSourceImpl
import com.android.clutch.data.remote.ValorantApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val baseUrl = BuildConfig.BASE_URL

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<AgentRepository> { AgentRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    single<ValorantApi> {
        getValorantApi(get())
    }

    single {
        getDataBase(get())
    }

    single {
        providesAgentDao(get())
    }
}

private fun getValorantApi(retrofit: Retrofit) = retrofit.create(ValorantApi::class.java)

private fun getDataBase(context: Context): AgentDatabase = Room.databaseBuilder(
    context,
    AgentDatabase::class.java, "valorant-db"
).build()

private fun providesAgentDao(db: AgentDatabase): AgentDao = db.getAgentDao()