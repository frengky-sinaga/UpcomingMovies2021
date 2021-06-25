package com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieGenreEntity

data class MovieWithGenres(
    @Embedded
    val movieEntity: MovieEntity,

    @Relation(
        parentColumn = "movie_id",
        entityColumn = "movie_genre_id",
        associateBy = Junction(MovieGenreCrossRef::class)
    )
    val movieGenres: List<MovieGenreEntity>
)
