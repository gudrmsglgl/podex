package com.example.network.di

import com.example.network.retrofit.PocketApi
import com.example.network.retrofit.PocketApiFactory
import com.example.network.source.PocketNetworkDataSource
import com.example.network.source.PocketNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    companion object {
        @Provides
        @Singleton
        fun provideNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
        }

        @Provides
        @Singleton
        fun providePokeService(json: Json): PocketApi {
            return PocketApiFactory.makePocketService(json)
        }
    }

    @Binds
    abstract fun bindPocketNetworkDataSource(
        dataSourceImpl: PocketNetworkDataSourceImpl
    ): PocketNetworkDataSource
}