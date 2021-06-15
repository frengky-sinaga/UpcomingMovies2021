package com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow


import com.google.gson.annotations.SerializedName

data class TvOnTheAirResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TvShowResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)