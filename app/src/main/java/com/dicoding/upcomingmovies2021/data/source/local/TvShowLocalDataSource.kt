package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.*
import com.dicoding.upcomingmovies2021.data.source.local.room.TvShowDao
import javax.inject.Inject

class TvShowLocalDataSource @Inject constructor(private val tvShowDao: TvShowDao) :
    ITvShowLocalDataSource {
    override fun insertTvShow(tvShowEntity: TvShowEntity) = tvShowDao.insertTvShow(tvShowEntity)

    override fun insertDetailTvShow(detailTvShowEntity: DetailTvShowEntity) =
        tvShowDao.insertDetailTvShow(detailTvShowEntity)

    override fun insertTvShowGenre(tvShowGenreEntity: TvShowGenreEntity) =
        tvShowDao.insertTvShowGenre(tvShowGenreEntity)

    override fun insertTvShowCompany(tvShowCompanyEntity: TvShowCompanyEntity) =
        tvShowDao.insertTvShowCompany(tvShowCompanyEntity)

    override fun insertTvShowGenreCrossRef(tvShowGenreCrossRef: TvShowGenreCrossRef) =
        tvShowDao.insertTvShowGenreCrossRef(tvShowGenreCrossRef)

    override fun insertTvShowCompanyCrossRef(tvShowCompanyCrossRef: TvShowCompanyCrossRef) =
        tvShowDao.insertTvShowCompanyCrossRef(tvShowCompanyCrossRef)

    override fun getTvShowAndDetailWithTvShowId(tvShowId: Int): LiveData<List<TvShowAndDetail>> =
        tvShowDao.getTvShowAndDetailWithTvShowId(tvShowId)

    override fun getTvShowsOfGenre(tvShowGenreId: Int): LiveData<List<GenreWithTvShows>> =
        tvShowDao.getTvShowsOfGenre(tvShowGenreId)

    override fun getGenresOfTvShow(tvShowId: Int): LiveData<List<TvShowWithGenres>> =
        tvShowDao.getGenresOfTvShow(tvShowId)

    override fun getCompaniesOfTvShow(tvShowId: Int): LiveData<List<TvShowWithCompanies>> =
        tvShowDao.getCompaniesOfTvShow(tvShowId)

    override fun getTvShows(): LiveData<List<TvShowEntity>> = tvShowDao.getTvShows()
}