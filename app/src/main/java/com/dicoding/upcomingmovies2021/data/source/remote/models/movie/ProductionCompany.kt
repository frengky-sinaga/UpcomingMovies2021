package com.dicoding.upcomingmovies2021.data.source.remote.models.movie


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductionCompany(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
) : Parcelable