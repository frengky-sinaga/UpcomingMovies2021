package com.dicoding.upcomingmovies2021.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.*

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movieEntities: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailMovie(detailMovieEntity: DetailMovieEntity)

    @Transaction
    @Query("SELECT * FROM movie_genre_entity WHERE movie_genre_id = :movieGenreId")
    fun getMoviesOfGenre(movieGenreId: Int): LiveData<List<GenreWithMovies>>

    @Query("SELECT * FROM movies_entity")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM detail_movie_entity WHERE detail_movie_id = :movieId")
    fun getDetailMovie(movieId: Int): LiveData<DetailMovieEntity>
}