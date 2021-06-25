package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dicoding.upcomingmovies2021.data.source.local.entities.CompanyEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.GenreEmbedded

@Entity(tableName = "detail_tv_show_entity")
data class DetailTvShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "detail_tv_show_id")
    val detailTvShowId: Int,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "original_name")
    val originalName: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "poster_path")
    val posterPath: String?,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "genre")
    val genre: List<GenreEmbedded>,

    @ColumnInfo(name = "companies")
    val companies: List<CompanyEmbedded>
)