package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["tv_show_id", "tv_show_genre_id"])
data class TvShowGenreCrossRef(
    @ColumnInfo(name = "tv_show_id")
    val tvShowId: Int,

    @ColumnInfo(name = "tv_show_genre_id")
    val tvShowGenreId: Int
)