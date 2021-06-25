package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.*

interface ITvShowLocalDataSource {

    fun insertTvShow(tvShowEntity: TvShowEntity)
    fun insertDetailTvShow(detailTvShowEntity: DetailTvShowEntity)
    fun insertTvShowGenre(tvShowGenreEntity: TvShowGenreEntity)
    fun insertTvShowCompany(tvShowCompanyEntity: TvShowCompanyEntity)
    fun insertTvShowGenreCrossRef(tvShowGenreCrossRef: TvShowGenreCrossRef)
    fun insertTvShowCompanyCrossRef(tvShowCompanyCrossRef: TvShowCompanyCrossRef)

    fun getTvShowAndDetailWithTvShowId(tvShowId: Int): LiveData<List<TvShowAndDetail>>
    fun getTvShowsOfGenre(tvShowGenreId: Int): LiveData<List<GenreWithTvShows>>
    fun getGenresOfTvShow(tvShowId: Int): LiveData<List<TvShowWithGenres>>
    fun getCompaniesOfTvShow(tvShowId: Int): LiveData<List<TvShowWithCompanies>>
    fun getTvShows(): LiveData<List<TvShowEntity>>
}