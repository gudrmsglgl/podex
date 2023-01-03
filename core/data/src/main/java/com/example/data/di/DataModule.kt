package com.example.data.di

import com.example.data.repository.PodexRepository
import com.example.data.repository.PodexRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsPodexRepository(repositoryImpl: PodexRepositoryImpl): PodexRepository
}