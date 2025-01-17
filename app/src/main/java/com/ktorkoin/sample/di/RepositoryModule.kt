package com.ktorkoin.sample.di

import com.ktorkoin.sample.data.repository.RemoteRepositoryImpl
import com.ktorkoin.sample.network.ApiService
import org.koin.dsl.module

val repositoryModule = module {
    single { provideRemoteRepository(get()) }
}

fun provideRemoteRepository(apiService: ApiService): RemoteRepositoryImpl {
    return RemoteRepositoryImpl(apiService)
}