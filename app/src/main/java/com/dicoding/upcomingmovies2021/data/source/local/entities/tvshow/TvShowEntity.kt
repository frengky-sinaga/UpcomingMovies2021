package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_entity")
data class TvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tv_show_id")
    val tvShowId: Int,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,

    @ColumnInfo(name ="name")
    val name: String,

    @ColumnInfo(name ="original_name")
    val originalName: String,

    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
)