package com.dicoding.upcomingmovies2021.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.*

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShowEntity: TvShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailTvShow(detailTvShowEntity: DetailTvShowEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShowGenre(tvShowGenreEntity: TvShowGenreEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShowCompany(tvShowCompanyEntity: TvShowCompanyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShowGenreCrossRef(tvShowGenreCrossRef: TvShowGenreCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShowCompanyCrossRef(tvShowCompanyCrossRef: TvShowCompanyCrossRef)

    @Transaction
    @Query("SELECT * FROM tv_show_entity WHERE tv_show_id = :tvShowId")
    fun getTvShowAndDetailWithTvShowId(tvShowId: Int): LiveData<List<TvShowAndDetail>>

    @Transaction
    @Query("SELECT * FROM tv_show_genre_entity WHERE tv_show_genre_id = :tvShowGenreId")
    fun getTvShowsOfGenre(tvShowGenreId: Int): LiveData<List<GenreWithTvShows>>

    @Transaction
    @Query("SELECT * FROM tv_show_entity WHERE tv_show_id = :tvShowId")
    fun getGenresOfTvShow(tvShowId: Int): LiveData<List<TvShowWithGenres>>

    @Transaction
    @Query("SELECT * FROM tv_show_entity WHERE tv_show_id = :tvShowId")
    fun getCompaniesOfTvShow(tvShowId: Int): LiveData<List<TvShowWithCompanies>>

    @Query("SELECT * FROM movies_entity")
    fun getTvShows(): LiveData<List<TvShowEntity>>
}