package com.dicoding.upcomingmovies2021.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.*

interface IMovieLocalDataSource {

    fun insertMovie(movieEntity: MovieEntity)
    fun insertDetailMovie(detailMovieEntity: DetailMovieEntity)
    fun insertMovieGenre(movieGenreEntity: MovieGenreEntity)
    fun insertMovieCompany(movieCompanyEntity: MovieCompanyEntity)
    fun insertMovieGenreCrossRef(movieGenreCrossRef: MovieGenreCrossRef)
    fun insertMovieCompanyCrossRef(movieCompanyCrossRef: MovieCompanyCrossRef)

    fun getMovieAndDetailByMovieId(movieId: Int): LiveData<List<MovieAndDetail>>
    fun getMoviesOfGenre(movieGenreId: Int): LiveData<List<GenreWithMovies>>
    fun getGenresOfMovie(movieId: Int): LiveData<List<MovieWithGenres>>
    fun getCompaniesOfMovie(movieId: Int): LiveData<List<MovieWithCompanies>>
    fun getMovies(): LiveData<List<MovieEntity>>
}