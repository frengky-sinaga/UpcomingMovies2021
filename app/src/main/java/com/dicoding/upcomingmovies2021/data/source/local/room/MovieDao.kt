package com.dicoding.upcomingmovies2021.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.*

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieEntity: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailMovie(detailMovieEntity: DetailMovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieGenre(movieGenreEntity: MovieGenreEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieCompany(movieCompanyEntity: MovieCompanyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieGenreCrossRef(movieGenreCrossRef: MovieGenreCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieCompanyCrossRef(movieCompanyCrossRef: MovieCompanyCrossRef)

    @Transaction
    @Query("SELECT * FROM movies_entity WHERE movie_id = :movieId")
    fun getMovieAndDetailByMovieId(movieId: Int): LiveData<List<MovieAndDetail>>

    @Transaction
    @Query("SELECT * FROM movie_genre_entity WHERE movie_genre_id = :movieGenreId")
    fun getMoviesOfGenre(movieGenreId: Int): LiveData<List<GenreWithMovies>>

    @Transaction
    @Query("SELECT * FROM movies_entity WHERE movie_id = :movieId")
    fun getGenresOfMovie(movieId: Int): LiveData<List<MovieWithGenres>>

    @Transaction
    @Query("SELECT * FROM movies_entity WHERE movie_id = :movieId")
    fun getCompaniesOfMovie(movieId: Int): LiveData<List<MovieWithCompanies>>

    @Query("SELECT * FROM movies_entity")
    fun getMovies(): LiveData<List<MovieEntity>>
}