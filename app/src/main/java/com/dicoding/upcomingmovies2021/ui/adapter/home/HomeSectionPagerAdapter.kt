package com.dicoding.upcomingmovies2021.ui.adapter.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.upcomingmovies2021.ui.fragments.home.MovieFragment
import com.dicoding.upcomingmovies2021.ui.fragments.home.TvShowFragment

class HomeSectionPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }
}