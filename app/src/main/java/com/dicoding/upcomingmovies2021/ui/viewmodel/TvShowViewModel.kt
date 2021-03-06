package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.upcomingmovies2021.data.repositories.TvShowRepository
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val tvShowRepository: TvShowRepository
) : ViewModel() {

    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = tvShowRepository.getTvShows()

    fun getFavTvShows(): LiveData<PagedList<DetailTvShowEntity>> = tvShowRepository.getFavoriteTvShows()

    fun deleteAllFavorites() = tvShowRepository.deleteAllFavTvShows()

}