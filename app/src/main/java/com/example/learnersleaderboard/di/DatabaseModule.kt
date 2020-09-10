package com.example.learnersleaderboard.di

import android.app.Application
import androidx.room.Room
import com.example.learnersleaderboard.data.database.AppDatabase
import com.example.learnersleaderboard.data.database.dao.HoursLeaderDao
import com.example.learnersleaderboard.data.database.dao.SkillLeaderDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)

@Module
object DatabaseModule {

    @Provides
    fun providesAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "leadersboard.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesHoursLeaderDao(appDatabase: AppDatabase): HoursLeaderDao {
        return appDatabase.hoursLeaderDao()
    }

    @Provides
    fun providesSkillLeaderDao(appDatabase: AppDatabase): SkillLeaderDao {
        return appDatabase.skillLeaderDao()
    }
}