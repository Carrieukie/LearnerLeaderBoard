package com.example.learnersleaderboard.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.learnersleaderboard.repository.MainRepository
import com.example.learnersleaderboard.util.Coroutines.lazyDeferred

class MainViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    val hoursLeaders by lazyDeferred { mainRepository.getHoursLeader() }

    val skillLeaders by lazyDeferred { mainRepository.getSkillLeader() }


}