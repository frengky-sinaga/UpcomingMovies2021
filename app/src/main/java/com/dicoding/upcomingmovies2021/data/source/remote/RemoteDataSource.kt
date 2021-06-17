package com.dicoding.upcomingmovies2021.data.source.remote

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.UpcomingMoviesResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvOnTheAirResponse
import com.dicoding.upcomingmovies2021.data.source.remote.network.ApiResponse

interface RemoteDataSource {

    fun getUpcomingMovies(): LiveData<ApiResponse<UpcomingMoviesResponse>>

    fun getTvOnTheAir(): LiveData<ApiResponse<TvOnTheAirResponse>>

    fun getDetailMovie(id: Int): LiveData<ApiResponse<DetailMovieResponse>>

    fun getDetailTvShow(id: Int): LiveData<ApiResponse<DetailTvShowResponse>>
}