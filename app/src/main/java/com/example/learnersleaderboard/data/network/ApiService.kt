package com.example.learnersleaderboard.data.network

import com.example.learnersleaderboard.model.HoursLeaderModel
import com.example.learnersleaderboard.model.SkillLeadersModel
import com.example.learnersleaderboard.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.HOURS_ENDPOINT)
    suspend fun fetchHoursLeaders(): Response<List<HoursLeaderModel>>

    @GET(Constants.SKILLIQ_ENDPOINT)
    suspend fun fetchSkillLeaders(): Response<List<SkillLeadersModel>>

}