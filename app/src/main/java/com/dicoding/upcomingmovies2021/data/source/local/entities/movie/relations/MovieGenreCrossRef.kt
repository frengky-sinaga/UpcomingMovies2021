package com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["movie_id", "movie_genre_id"])
data class MovieGenreCrossRef(
    @ColumnInfo(name = "movie_id")
    val movieId: Int,

    @ColumnInfo(name = "movie_genre_id")
    val movieGenreId: Int
)