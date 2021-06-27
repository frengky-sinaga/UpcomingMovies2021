package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.room.MovieDao
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) :
    IMovieLocalDataSource {
    override fun insertMovies(movieEntities: List<MovieEntity>) =
        movieDao.insertMovies(movieEntities)

    override fun insertDetailMovie(detailMovieEntity: DetailMovieEntity) =
        movieDao.insertDetailMovie(detailMovieEntity)

    override fun getMovies(): LiveData<List<MovieEntity>> = movieDao.getMovies()

    override fun getDetailMovie(movieId: Int): LiveData<DetailMovieEntity> =
        movieDao.getDetailMovie(movieId)

    override fun getFavoriteMovies(): LiveData<List<DetailMovieEntity>> =
        movieDao.getFavoriteMovies()

    override fun setFavMovie(detailMovieEntity: DetailMovieEntity, newFavState: Boolean) {
        detailMovieEntity.favorite = newFavState
        movieDao.setFavMovie(detailMovieEntity)
    }

    override fun deleteAllFavMovies() = movieDao.deleteAllFavMovies()
}