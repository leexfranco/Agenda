package com.generation.myapplication.d_i

import com.generation.myapplication.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton

    fun providesRepository() :: Repository{
        return Repository()
    }
}