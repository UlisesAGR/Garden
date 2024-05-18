package com.garden.mobile.di.local

import android.content.Context
import androidx.room.Room
import com.garden.mobile.BuildConfig.DATABASE_NAME
import com.garden.mobile.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME,
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideGardenDao(db: AppDatabase) = db.gardenDao()

    @Singleton
    @Provides
    fun providePlantsDao(db: AppDatabase) = db.plantsDao()
}
