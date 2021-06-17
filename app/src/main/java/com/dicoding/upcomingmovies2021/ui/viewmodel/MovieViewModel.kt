package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.upcomingmovies2021.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val filmRepository: FilmRepository
): ViewModel() {

    val movieResult by lazy {
        filmRepository.getUpcomingMovies()
    }
}