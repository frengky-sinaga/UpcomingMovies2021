package com.dicoding.upcomingmovies2021.data

import com.dicoding.upcomingmovies2021.utils.Genre
import com.dicoding.upcomingmovies2021.utils.TypeFilm

data class DetailFilmEntity(
    var idFilm: String,
    var title: String,
    var poster: String,
    var genre: List<Genre>,
    var releaseDate: String,
    var crews: CrewFilmEntity,
    var description: String,
    var link: String,
    var typeFilm: TypeFilm,
)
