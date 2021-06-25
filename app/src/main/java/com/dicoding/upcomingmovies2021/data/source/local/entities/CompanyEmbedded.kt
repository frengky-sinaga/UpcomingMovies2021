package com.dicoding.upcomingmovies2021.data.source.local.entities

import androidx.room.ColumnInfo

data class CompanyEmbedded(
    @ColumnInfo(name = "movie_company_id")
    val movieCompanyId: Int,
    @ColumnInfo(name = "company_name")
    val companyName: String,
)