package com.dicoding.upcomingmovies2021.data.source.remote.network

import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.UpcomingMoviesResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvOnTheAirResponse
import com.dicoding.upcomingmovies2021.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMovieDbApiService {

    @GET("movie/upcoming?api_key=${API_KEY}")
    fun getUpcomingMovie(): Call<UpcomingMoviesResponse>

    @GET("movie/{movie_id}?api_key=${API_KEY}")
    fun getDetailMovie(@Path("movie_id") movieId: Int): Call<DetailMovieResponse>

    @GET("tv/on_the_air?api_key=${API_KEY}")
    fun getTvShowOnTheAir(): Call<TvOnTheAirResponse>

    @GET("tv/{tv_id}?api_key=${API_KEY}")
    fun getDetailTvShow(@Path("tv_id") tvId: Int): Call<DetailTvShowResponse>
}