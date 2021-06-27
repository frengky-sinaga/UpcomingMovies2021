package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.room.TvShowDao
import javax.inject.Inject

class TvShowLocalDataSource @Inject constructor(private val tvShowDao: TvShowDao) :
    ITvShowLocalDataSource {
    override fun insertTvShows(tvShowEntities: List<TvShowEntity>) =
        tvShowDao.insertTvShows(tvShowEntities)

    override fun insertDetailTvShow(detailTvShowEntity: DetailTvShowEntity) =
        tvShowDao.insertDetailTvShow(detailTvShowEntity)

    override fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = tvShowDao.getTvShows()

    override fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowEntity> =
        tvShowDao.getDetailTvShow(tvShowId)

    override fun getFavoriteTvShows(): DataSource.Factory<Int, DetailTvShowEntity> =
        tvShowDao.getFavoriteTvShows()

    override fun setFavTvShow(detailTvShowEntity: DetailTvShowEntity, newFavState: Boolean) {
        detailTvShowEntity.favorite = newFavState
        tvShowDao.setFavTvShow(detailTvShowEntity)
    }

    override fun deleteAllFavTvShows() = tvShowDao.deleteAllFavTvShows()
}