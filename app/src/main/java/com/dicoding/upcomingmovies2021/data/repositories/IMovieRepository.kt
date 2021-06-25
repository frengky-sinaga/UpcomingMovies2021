package com.dicoding.upcomingmovies2021.data.repositories

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.GenreWithMovies
import com.dicoding.upcomingmovies2021.vo.Resource

interface IMovieRepository {
    fun getMoviesOfGenre(movieGenreId: Int): LiveData<List<GenreWithMovies>>
    fun getMovies(): LiveData<Resource<List<MovieEntity>>>
    fun getDetailMovie(movieId: Int): LiveData<Resource<DetailMovieEntity>>
}