package com.example.learnersleaderboard.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learnersleaderboard.model.SkillLeadersModel

@Dao
interface SkillLeaderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSkillLeaders(skillLeaders: List<SkillLeadersModel>)

    @Query("SELECT * FROM skill_leaders_table")
    fun getSkillLeaders(): LiveData<List<SkillLeadersModel>>

}