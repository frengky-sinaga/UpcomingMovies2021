package com.dicoding.upcomingmovies2021.data

data class CrewFilmEntity(
    var director: String?,
    var writers: List<String>?,
    var stars: List<String>,
)