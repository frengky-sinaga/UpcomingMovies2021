package com.dicoding.upcomingmovies2021.ui.fragments.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentMovieFavoritesBinding

class MovieFavoritesFragment : Fragment(R.layout.fragment_movie_favorites) {

    private lateinit var binding: FragmentMovieFavoritesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieFavoritesBinding.bind(view)
    }
}