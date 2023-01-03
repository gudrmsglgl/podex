package com.example.common.dispatcher.di

import com.example.common.dispatcher.PodexDispatchers
import com.example.common.dispatcher.InjectionDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DisPatchersModule {
    @Provides
    @InjectionDispatcher(PodexDispatchers.IO)
    fun provideDispatchers(): CoroutineDispatcher = Dispatchers.IO
}