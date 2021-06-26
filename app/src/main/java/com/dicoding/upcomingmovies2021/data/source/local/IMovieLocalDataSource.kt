package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.GenreWithMovies

interface IMovieLocalDataSource {
    fun insertMovies(movieEntities: List<MovieEntity>)
    fun insertDetailMovie(detailMovieEntity: DetailMovieEntity)
    fun getMoviesOfGenre(movieGenreId: Int): LiveData<List<GenreWithMovies>>
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getDetailMovie(movieId: Int): LiveData<DetailMovieEntity>
    fun getFavoriteMovies(): LiveData<List<DetailMovieEntity>>
    fun setFavMovie(detailMovieEntity: DetailMovieEntity, newFavState: Boolean)
    fun deleteAllFavMovies()
}