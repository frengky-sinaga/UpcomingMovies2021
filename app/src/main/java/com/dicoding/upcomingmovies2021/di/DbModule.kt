package com.dicoding.upcomingmovies2021.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.upcomingmovies2021.data.source.local.room.FilmDb
import com.dicoding.upcomingmovies2021.data.source.local.room.MovieDao
import com.dicoding.upcomingmovies2021.data.source.local.room.TvShowDao
import com.dicoding.upcomingmovies2021.utils.AppExecutors
import com.dicoding.upcomingmovies2021.utils.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    fun provideAppExecutors(): AppExecutors = AppExecutors()

    @Singleton
    @Provides
    fun provideFilmDb(
        @ApplicationContext context: Context
    ): FilmDb = Room.databaseBuilder(context, FilmDb::class.java, DB_NAME).build()

    @Singleton
    @Provides
    fun provideMovieDao(database: FilmDb): MovieDao = database.movieDao()

    @Singleton
    @Provides
    fun provideTvShowDao(database: FilmDb): TvShowDao = database.tvShowDao()
}