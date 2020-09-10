package com.example.learnersleaderboard.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.learnersleaderboard.R
import com.example.learnersleaderboard.model.SkillLeadersModel
import com.example.learnersleaderboard.ui.adapters.SkillLeadersRecyclerViewAdapter
import com.example.learnersleaderboard.ui.viewmodels.MainViewModel
import com.example.learnersleaderboard.util.Coroutines
import com.example.learnersleaderboard.util.hide
import com.example.learnersleaderboard.util.log
import com.example.learnersleaderboard.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_skill_leaders.*

@AndroidEntryPoint
class SkillLeadersFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_skill_leaders, container, false)

        initRecyclerView()

        return root
    }

    private fun initRecyclerView() {
        skills_progressBar?.show()

        val skillLeadersList = arrayListOf<SkillLeadersModel>()
        val adapter = SkillLeadersRecyclerViewAdapter(requireActivity(), skillLeadersList)

        Coroutines.main {
            viewModel.skillLeaders.await().observe(viewLifecycleOwner, Observer {
                for (i in it.indices) {
                    skillLeadersList.add(i, it[i])
                    skill_recyclerview.adapter = adapter
                    skills_progressBar?.hide()
                }
                requireActivity().applicationContext.log(skillLeadersList.size.toString())
            })
        }
    }

}