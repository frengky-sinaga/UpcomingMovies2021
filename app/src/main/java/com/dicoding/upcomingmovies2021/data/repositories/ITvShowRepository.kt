package com.dicoding.upcomingmovies2021.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.vo.Resource

interface ITvShowRepository {
    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>
    fun getDetailTvShow(tvShowId: Int): LiveData<Resource<DetailTvShowEntity>>
    fun getFavoriteTvShows(): LiveData<PagedList<DetailTvShowEntity>>
    fun setFavTvShow(detailTvShowEntity: DetailTvShowEntity, newFavState: Boolean)
    fun deleteAllFavTvShows()
}