package com.dicoding.upcomingmovies2021.data.source.local.converters

import androidx.room.TypeConverter
import com.dicoding.upcomingmovies2021.data.source.local.entities.CompanyEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.GenreEmbedded
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun genreListToJson(value: List<GenreEmbedded>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToGenreList(value: String) =
        Gson().fromJson(value, Array<GenreEmbedded>::class.java).toList()

    @TypeConverter
    fun companyListToJson(value: List<CompanyEmbedded>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToCompanyList(value: String) =
        Gson().fromJson(value, Array<CompanyEmbedded>::class.java).toList()
}