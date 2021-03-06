package com.example.learnersleaderboard.ui.activities;

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learnersleaderboard.R
import com.example.learnersleaderboard.ui.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        view_pager.adapter = adapter
        tab_layout.setupWithViewPager(view_pager)

        toSubmit_button.setOnClickListener {
            startActivity(Intent(this, SubmitActivity::class.java))
            finish()
        }

    }
}