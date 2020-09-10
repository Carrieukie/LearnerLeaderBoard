package com.example.learnersleaderboard.repository

import com.example.learnersleaderboard.data.network.ApiSubmissionService
import com.example.learnersleaderboard.data.network.SafeApiRequest
import javax.inject.Inject

class SubmissionRepository @Inject constructor(private val apiSubmissionService: ApiSubmissionService) :
    SafeApiRequest() {

    suspend fun submitProject(
        emailAddress: String,
        firstName: String,
        lastName: String,
        projectLink: String
    ): Any {
        return safeApiRequest {
            apiSubmissionService.submitProject(
                emailAddress,
                firstName,
                lastName,
                projectLink
            )
        }
    }

}