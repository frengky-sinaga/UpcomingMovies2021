package com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieGenreEntity

data class GenreWithMovies(
    @Embedded
    val movieGenres: MovieGenreEntity,

    @Relation(
        parentColumn = "movie_genre_id",
        entityColumn = "movie_id",
    )
    val movieEntity: List<MovieEntity>
)
