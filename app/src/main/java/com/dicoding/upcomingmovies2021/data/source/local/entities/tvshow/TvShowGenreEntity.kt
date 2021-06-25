package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_genre_entity")
data class TvShowGenreEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tv_show_genre_id")
    val tvShowGenreId: Int
)