package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity

interface IMovieLocalDataSource {
    fun insertMovies(movieEntities: List<MovieEntity>)
    fun insertDetailMovie(detailMovieEntity: DetailMovieEntity)
    fun getMovies(): DataSource.Factory<Int, MovieEntity>
    fun getDetailMovie(movieId: Int): LiveData<DetailMovieEntity>
    fun getFavoriteMovies(): DataSource.Factory<Int, DetailMovieEntity>
    fun setFavMovie(detailMovieEntity: DetailMovieEntity, newFavState: Boolean)
    fun deleteAllFavMovies()
}