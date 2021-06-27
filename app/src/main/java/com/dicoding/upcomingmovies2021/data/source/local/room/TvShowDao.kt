package com.dicoding.upcomingmovies2021.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShowEntities: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailTvShow(detailTvShowEntity: DetailTvShowEntity)

    @Query("SELECT * FROM tv_show_entity")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM detail_tv_show_entity WHERE detail_tv_show_id = :tvShowId")
    fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowEntity>

    @Query("SELECT * FROM detail_tv_show_entity WHERE favorite = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, DetailTvShowEntity>

    @Update
    fun setFavTvShow(detailTvShowEntity: DetailTvShowEntity)

    @Query("DELETE FROM detail_tv_show_entity WHERE favorite = 1")
    fun deleteAllFavTvShows()
}