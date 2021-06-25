package com.dicoding.upcomingmovies2021.ui.fragments.favorites

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentFavoritesBinding
import com.dicoding.upcomingmovies2021.ui.adapter.favorites.FavoritesSectionPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.fav_movie_list,
            R.string.fav_tv_show_list
        )
    }

    private lateinit var binding: FragmentFavoritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoritesBinding.bind(view)

        setPagerAdapter()
    }

    private fun setPagerAdapter() {
        val sectionPagerAdapter = FavoritesSectionPagerAdapter(this)
        val viewPager: ViewPager2 = binding.viewPagerFavorite
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = binding.tabsFavorite
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(FavoritesFragment.TAB_TITLES[position])
        }.attach()
    }
}