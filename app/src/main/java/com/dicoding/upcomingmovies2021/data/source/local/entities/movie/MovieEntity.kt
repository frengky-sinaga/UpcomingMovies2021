package com.dicoding.upcomingmovies2021.data.source.local.entities.movie

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_entity")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movie_id")
    val movieId: Int,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @ColumnInfo(name = "original_title")
    val originalTitle: String,

    @ColumnInfo(name = "poster_path")
    val posterPath: String?,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "title")
    val title: String,
)
