package com.example.learnersleaderboard.util

interface StateListener {

    fun onLoading()

    fun onSuccess(message: String)

    fun onFailure(message: String)
}