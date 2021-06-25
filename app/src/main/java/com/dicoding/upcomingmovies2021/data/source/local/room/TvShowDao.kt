package com.dicoding.upcomingmovies2021.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.GenreWithTvShows

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShowEntities: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailTvShow(detailTvShowEntity: DetailTvShowEntity)

    @Transaction
    @Query("SELECT * FROM tv_show_genre_entity WHERE tv_show_genre_id = :tvShowGenreId")
    fun getTvShowsOfGenre(tvShowGenreId: Int): LiveData<List<GenreWithTvShows>>

    @Query("SELECT * FROM movies_entity")
    fun getTvShows(): LiveData<List<TvShowEntity>>

    @Query("SELECT * FROM detail_tv_show_entity WHERE detail_tv_show_id = :tvShowId")
    fun getDetailTvShow(tvShowId: Int): LiveData<DetailTvShowEntity>
}