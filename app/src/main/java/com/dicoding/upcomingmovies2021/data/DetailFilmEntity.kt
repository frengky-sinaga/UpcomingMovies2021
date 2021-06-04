package com.dicoding.upcomingmovies2021.data

data class DetailFilmEntity(
    var title: String,
    var poster: String,
    var genre: List<String>,
    var releaseDate: String,
    var crews: CrewFilmEntity,
    var description: String,
    var link: String,
)
