package com.dicoding.upcomingmovies2021.data

import com.dicoding.upcomingmovies2021.utils.Genre
import com.dicoding.upcomingmovies2021.utils.TypeFilm

data class DetailFilmEntity(
    val idFilm: String,
    val title: String,
    val poster: String,
    val genre: List<Genre>,
    val releaseDate: String,
    val crews: CrewFilmEntity,
    val description: String,
    val link: String,
    val typeFilm: TypeFilm,
)
