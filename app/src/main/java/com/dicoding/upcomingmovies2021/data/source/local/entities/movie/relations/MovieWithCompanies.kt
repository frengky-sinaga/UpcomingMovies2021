package com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity

data class MovieWithCompanies(
    @Embedded
    val movieEntity: MovieEntity,

    @Relation(
        parentColumn = "movie_id",
        entityColumn = "movie_company_id",
        associateBy = Junction(MovieCompanyCrossRef::class)
    )
    val movieCompanies: List<MovieCompanyEntity>
)
