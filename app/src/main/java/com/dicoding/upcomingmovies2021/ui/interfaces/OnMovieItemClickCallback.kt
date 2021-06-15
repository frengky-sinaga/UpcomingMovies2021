package com.dicoding.upcomingmovies2021.ui.interfaces

import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.MovieResult

interface OnMovieItemClickCallback {
    fun onItemClicked(data: MovieResult)
}