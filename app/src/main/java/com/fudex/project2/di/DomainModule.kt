package com.fudex.project2.di

import com.fudex.project2.domain.data_interfaces.DbRepository
import com.fudex.project2.domain.data_interfaces.RemoteRepository
import com.fudex.project2.domain.use_cases.GetImageOfDayUseCase
import com.fudex.project2.domain.use_cases.GetDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Singleton
    fun provideGetResponseUseCase(repository: RemoteRepository, dbRepository: DbRepository) =
        GetDataUseCase(repository, dbRepository)

    @Provides
    @Singleton
    fun provideGetImageOfTheDayUseCase(remoteRepository: RemoteRepository) =
        GetImageOfDayUseCase(remoteRepository)
}