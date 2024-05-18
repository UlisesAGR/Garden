package com.garden.mobile.di.repository

import com.garden.mobile.data.repository.GardenRepositoryImpl
import com.garden.mobile.data.repository.PlantsRepositoryImpl
import com.garden.mobile.domian.repository.GardenRepository
import com.garden.mobile.domian.repository.PlantsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideGardenRepository(gardenRepositoryImpl: GardenRepositoryImpl): GardenRepository

    @Singleton
    @Binds
    abstract fun providePlantsRepository(plantsRepositoryImpl: PlantsRepositoryImpl): PlantsRepository
}
