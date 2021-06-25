package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.*
import com.dicoding.upcomingmovies2021.data.source.local.room.MovieDao
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) :
    IMovieLocalDataSource {
    override fun insertMovie(movieEntity: MovieEntity) = movieDao.insertMovie(movieEntity)

    override fun insertDetailMovie(detailMovieEntity: DetailMovieEntity) =
        movieDao.insertDetailMovie(detailMovieEntity)

    override fun insertMovieGenre(movieGenreEntity: MovieGenreEntity) =
        movieDao.insertMovieGenre(movieGenreEntity)

    override fun insertMovieCompany(movieCompanyEntity: MovieCompanyEntity) =
        movieDao.insertMovieCompany(movieCompanyEntity)

    override fun insertMovieGenreCrossRef(movieGenreCrossRef: MovieGenreCrossRef) =
        movieDao.insertMovieGenreCrossRef(movieGenreCrossRef)

    override fun insertMovieCompanyCrossRef(movieCompanyCrossRef: MovieCompanyCrossRef) =
        movieDao.insertMovieCompanyCrossRef(movieCompanyCrossRef)

    override fun getMovieAndDetailByMovieId(movieId: Int): LiveData<List<MovieAndDetail>> =
        movieDao.getMovieAndDetailByMovieId(movieId)

    override fun getMoviesOfGenre(movieGenreId: Int): LiveData<List<GenreWithMovies>> =
        movieDao.getMoviesOfGenre(movieGenreId)

    override fun getGenresOfMovie(movieId: Int): LiveData<List<MovieWithGenres>> =
        movieDao.getGenresOfMovie(movieId)

    override fun getCompaniesOfMovie(movieId: Int): LiveData<List<MovieWithCompanies>> =
        movieDao.getCompaniesOfMovie(movieId)

    override fun getMovies(): LiveData<List<MovieEntity>> = movieDao.getMovies()
}