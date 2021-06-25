package com.dicoding.upcomingmovies2021.ui.adapter.favorites

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.upcomingmovies2021.ui.fragments.favorites.MovieFavoritesFragment
import com.dicoding.upcomingmovies2021.ui.fragments.favorites.TvShowFavoritesFragment

class FavoritesSectionPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFavoritesFragment()
            1 -> fragment = TvShowFavoritesFragment()
        }
        return fragment as Fragment
    }
}