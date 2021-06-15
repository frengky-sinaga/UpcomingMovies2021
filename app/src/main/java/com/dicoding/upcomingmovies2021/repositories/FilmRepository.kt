package com.dicoding.upcomingmovies2021.repositories

import com.dicoding.upcomingmovies2021.data.source.remote.network.TheMovieDbApiService
import javax.inject.Inject

class FilmRepository @Inject constructor(
    private val movieDbApiService: TheMovieDbApiService
) {
    suspend fun getUpcomingMovies() = movieDbApiService.getUpcomingMovie()

    suspend fun getDetailMovie(id: Int) = movieDbApiService.getDetailMovie(id)

    suspend fun getTvShows() = movieDbApiService.getTvShowOnTheAir()

    suspend fun getDetailTvShow(id: Int) = movieDbApiService.getDetailTvShow(id)
}