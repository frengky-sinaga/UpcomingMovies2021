package com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity

data class TvShowWithCompanies(
    @Embedded
    val tvShowEntity: TvShowEntity,

    @Relation(
        parentColumn = "tv_show_id",
        entityColumn = "tv_show_company_id",
        associateBy = Junction(TvShowCompanyCrossRef::class)
    )
    val tvShowCompany: List<TvShowCompanyEntity>
)
