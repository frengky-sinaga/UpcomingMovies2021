package com.dicoding.upcomingmovies2021.data.repositories

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.GenreWithTvShows
import com.dicoding.upcomingmovies2021.vo.Resource

interface ITvShowRepository {

    fun getTvShowsOfGenre(tvShowGenreId: Int): LiveData<List<GenreWithTvShows>>
    fun getTvShows(): LiveData<Resource<List<TvShowEntity>>>
    fun getDetailTvShow(tvShowId: Int): LiveData<Resource<DetailTvShowEntity>>
}