package com.dicoding.upcomingmovies2021.data.source.local.entities.movie

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_company_entity")
data class MovieCompanyEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movie_company_id")
    val movieCompanyId: Int,
    val companyName: String,
)