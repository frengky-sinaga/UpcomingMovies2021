package com.dicoding.upcomingmovies2021.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_UpcomingMovies2021)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}