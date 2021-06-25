package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tv_show_company_entity")
data class TvShowCompanyEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tv_show_company_id")
    val tvShowCompanyId: Int,
    val companyName: String,
)