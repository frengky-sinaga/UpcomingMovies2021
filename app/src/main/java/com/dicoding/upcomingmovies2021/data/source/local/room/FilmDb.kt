package com.dicoding.upcomingmovies2021.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.MovieCompanyCrossRef
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.MovieGenreCrossRef
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowCompanyEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.TvShowCompanyCrossRef
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.TvShowGenreCrossRef

@Database(
    entities = [
        MovieEntity::class,
        DetailMovieEntity::class,
        MovieCompanyEntity::class,
        MovieGenreEntity::class,
        MovieCompanyCrossRef::class,
        MovieGenreCrossRef::class,
        TvShowEntity::class,
        DetailTvShowEntity::class,
        TvShowCompanyEntity::class,
        TvShowGenreEntity::class,
        TvShowCompanyCrossRef::class,
        TvShowGenreCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class FilmDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
}