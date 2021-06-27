package com.dicoding.upcomingmovies2021.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movieEntities: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailMovie(detailMovieEntity: DetailMovieEntity)

    @Query("SELECT * FROM movies_entity")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM detail_movie_entity WHERE detail_movie_id = :movieId")
    fun getDetailMovie(movieId: Int): LiveData<DetailMovieEntity>

    @Query("SELECT * FROM detail_movie_entity WHERE favorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, DetailMovieEntity>

    @Update
    fun setFavMovie(detailMovieEntity: DetailMovieEntity)

    @Query("DELETE FROM detail_movie_entity WHERE favorite = 1")
    fun deleteAllFavMovies()
}