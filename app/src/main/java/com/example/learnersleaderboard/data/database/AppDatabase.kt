package com.example.learnersleaderboard.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learnersleaderboard.data.database.dao.HoursLeaderDao
import com.example.learnersleaderboard.data.database.dao.SkillLeaderDao
import com.example.learnersleaderboard.model.HoursLeaderModel
import com.example.learnersleaderboard.model.SkillLeadersModel

@Database(entities = [HoursLeaderModel::class, SkillLeadersModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun hoursLeaderDao(): HoursLeaderDao

    abstract fun skillLeaderDao(): SkillLeaderDao
}