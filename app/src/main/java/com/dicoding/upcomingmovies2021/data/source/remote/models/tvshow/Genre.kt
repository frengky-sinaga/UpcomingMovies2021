package com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)