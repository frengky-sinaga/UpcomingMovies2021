package com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["movie_id", "movie_company_entity"])
data class MovieCompanyCrossRef(
    @ColumnInfo(name = "movie_id")
    val movieId: Int,

    @ColumnInfo(name = "movie_company_id")
    val movieCompanyId: Int
)