package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowGenreEntity

data class GenreWithTvShows(
    @Embedded
    val tvShowGenreEntity: TvShowGenreEntity,

    @Relation(
        parentColumn = "tv_show_genre_id",
        entityColumn = "tv_show_id",
    )
    val tvShowEntity: List<TvShowEntity>
)
