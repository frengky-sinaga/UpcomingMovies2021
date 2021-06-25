package com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity

data class MovieAndDetail(
    @Embedded
    val movieEntity: MovieEntity,

    @Relation(
        parentColumn = "movie_id",
        entityColumn = "movie_id"
    )
    val detailMovieEntity: DetailMovieEntity
)
