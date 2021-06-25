package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity

data class TvShowAndDetail(
    @Embedded
    val tvShowEntity: TvShowEntity,

    @Relation(
        parentColumn = "tv_show_id",
        entityColumn = "tv_show_id"
    )
    val detailTvShowEntity: DetailTvShowEntity
)
