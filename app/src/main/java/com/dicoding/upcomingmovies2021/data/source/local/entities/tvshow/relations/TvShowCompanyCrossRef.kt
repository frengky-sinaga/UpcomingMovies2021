package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["tv_show_id", "tv_show_company_id"])
data class TvShowCompanyCrossRef(
    @ColumnInfo(name = "tv_show_id")
    val tvShowId: Int,

    @ColumnInfo(name = "tv_show_company_id")
    val tvShowCompanyId: Int,
)