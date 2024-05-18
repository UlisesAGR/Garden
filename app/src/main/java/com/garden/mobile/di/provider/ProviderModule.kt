package com.garden.mobile.di.provider

import com.garden.mobile.data.provider.ResourceProviderImpl
import com.garden.mobile.domian.provider.ResourceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProviderModule {
    @Singleton
    @Binds
    abstract fun provideResourceProvider(containerResourceProviderImpl: ResourceProviderImpl): ResourceProvider
}
