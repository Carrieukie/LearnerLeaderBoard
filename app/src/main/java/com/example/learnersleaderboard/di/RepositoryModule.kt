package com.example.learnersleaderboard.di

import com.example.learnersleaderboard.data.database.AppDatabase
import com.example.learnersleaderboard.data.network.ApiService
import com.example.learnersleaderboard.data.network.ApiSubmissionService
import com.example.learnersleaderboard.repository.MainRepository
import com.example.learnersleaderboard.repository.SubmissionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)

@Module
object RepositoryModule {

    @Provides
    fun providesMainRepository(
        apiService: ApiService,
        appDatabase: AppDatabase
    ): MainRepository {
        return MainRepository(apiService, appDatabase)
    }

    @Provides
    fun providesSubmissionRepository(apiSubmissionService: ApiSubmissionService): SubmissionRepository {
        return SubmissionRepository(apiSubmissionService)
    }
}