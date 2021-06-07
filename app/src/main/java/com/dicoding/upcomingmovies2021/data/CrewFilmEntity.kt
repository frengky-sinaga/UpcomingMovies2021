package com.dicoding.upcomingmovies2021.data

data class CrewFilmEntity(
    val creators: List<String>?,
    val directors: List<String>?,
    val writers: List<String>?,
    val stars: List<String>,
)