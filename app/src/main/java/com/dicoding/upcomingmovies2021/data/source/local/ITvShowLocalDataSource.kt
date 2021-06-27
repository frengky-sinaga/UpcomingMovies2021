package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity

interface ITvShowLocalDataSource {
    fun insertTvShows(tvShowEntities: List<TvShowEntity>)
    fun insertDetailTvShow(detailTvShowEntity: DetailTvShowEntity)
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>
    fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowEntity>
    fun getFavoriteTvShows(): DataSource.Factory<Int, DetailTvShowEntity>
    fun setFavTvShow(detailTvShowEntity: DetailTvShowEntity, newFavState: Boolean)
    fun deleteAllFavTvShows()
}