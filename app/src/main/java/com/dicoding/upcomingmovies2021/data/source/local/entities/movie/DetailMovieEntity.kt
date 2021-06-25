package com.dicoding.upcomingmovies2021.data.source.local.entities.movie

import androidx.annotation.NonNull
import androidx.room.*
import com.dicoding.upcomingmovies2021.data.source.local.entities.CompanyEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.GenreEmbedded

@Entity(tableName = "detail_movie_entity")
data class DetailMovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "detail_movie_id")
    val detailMovieId: Int,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @ColumnInfo(name = "original_title")
    val originalTitle: String,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "poster_path")
    val posterPath: String?,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "status")
    val status: String,

    @ColumnInfo(name = "genre")
    val genre: List<GenreEmbedded>,

    @ColumnInfo(name = "companies")
    val companies: List<CompanyEmbedded>
)
