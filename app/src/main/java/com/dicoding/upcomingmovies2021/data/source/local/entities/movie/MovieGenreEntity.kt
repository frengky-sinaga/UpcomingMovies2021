package com.dicoding.upcomingmovies2021.data.source.local.entities.movie

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_genre_entity")
data class MovieGenreEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movie_genre_id")
    val movieGenreId: Int
)