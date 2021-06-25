package com.dicoding.upcomingmovies2021.di

import android.content.Context
import androidx.room.Room
import com.dicoding.upcomingmovies2021.data.source.local.room.FilmDb
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

    @Singleton
    @Provides
    fun provideFilmDb(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, FilmDb::class.java, DB_NAME)

    @Singleton
    @Provides
    fun provideMovieDao(database: FilmDb) = database.movieDao()

    @Singleton
    @Provides
    fun provideTvShowDao(database: FilmDb) = database.tvShowDao()
}