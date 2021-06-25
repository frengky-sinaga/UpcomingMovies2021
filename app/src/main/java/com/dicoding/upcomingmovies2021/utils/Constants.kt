package com.dicoding.upcomingmovies2021.utils

import com.dicoding.upcomingmovies2021.BuildConfig

object Constants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = BuildConfig.API_KEY
    const val API_POSTER_PATH = "https://image.tmdb.org/t/p/w300"
    const val API_BACKDROP_PATH = "https://image.tmdb.org/t/p/w500"

    const val DB_NAME = "film_db"
}