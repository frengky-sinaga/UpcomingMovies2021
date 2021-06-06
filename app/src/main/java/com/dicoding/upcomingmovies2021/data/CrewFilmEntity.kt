package com.dicoding.upcomingmovies2021.data

data class CrewFilmEntity(
    var creators: List<String>?,
    var directors: List<String>?,
    var writers: List<String>?,
    var stars: List<String>,
)