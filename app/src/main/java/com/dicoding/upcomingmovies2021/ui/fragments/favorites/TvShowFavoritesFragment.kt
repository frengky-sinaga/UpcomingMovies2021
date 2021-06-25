package com.dicoding.upcomingmovies2021.ui.fragments.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentTvShowFavoritesBinding

class TvShowFavoritesFragment : Fragment(R.layout.fragment_tv_show_favorites) {

    private lateinit var binding: FragmentTvShowFavoritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTvShowFavoritesBinding.bind(view)
    }
}