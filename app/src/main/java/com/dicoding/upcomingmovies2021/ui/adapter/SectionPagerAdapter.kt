package com.dicoding.upcomingmovies2021.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.upcomingmovies2021.ui.fragments.FilmFragment

class SectionPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return FilmFragment.newInstance(position + 1)
    }
}