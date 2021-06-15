package com.dicoding.upcomingmovies2021.data.source.remote.models.movie


import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum")
    val maximum: String,
    @SerializedName("minimum")
    val minimum: String
)