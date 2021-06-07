package com.dicoding.upcomingmovies2021.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.ActivityMainBinding
import com.dicoding.upcomingmovies2021.ui.fragments.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_UpcomingMovies2021)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setHomeFragment()
    }

    private fun setHomeFragment() {
        val fm = supportFragmentManager
        val homeFragment = HomeFragment()
        val findFragment = fm.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (findFragment != homeFragment) {
            fm.beginTransaction()
                .add(binding.mainContainer.id, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}