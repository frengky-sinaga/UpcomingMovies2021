package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.GenreWithTvShows

interface ITvShowLocalDataSource {
    fun insertTvShows(tvShowEntities: List<TvShowEntity>)
    fun insertDetailTvShow(detailTvShowEntity: DetailTvShowEntity)
    fun getTvShowsOfGenre(tvShowGenreId: Int): LiveData<List<GenreWithTvShows>>
    fun getTvShows(): LiveData<List<TvShowEntity>>
    fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowEntity>
    fun getFavoriteTvShows(): LiveData<List<DetailTvShowEntity>>
    fun setFavTvShow(detailTvShowEntity: DetailTvShowEntity, newFavState: Boolean)
    fun deleteAllFavTvShows()
}