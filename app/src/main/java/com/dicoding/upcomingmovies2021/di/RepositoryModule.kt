package com.dicoding.upcomingmovies2021.di

import com.dicoding.upcomingmovies2021.data.source.remote.RemoteDataSourceImpl
import com.dicoding.upcomingmovies2021.data.source.remote.network.TheMovieDbApiService
import com.dicoding.upcomingmovies2021.data.repositories.FilmRepository
import com.dicoding.upcomingmovies2021.data.repositories.MovieRepository
import com.dicoding.upcomingmovies2021.data.repositories.TvShowRepository
import com.dicoding.upcomingmovies2021.data.source.local.MovieLocalDataSource
import com.dicoding.upcomingmovies2021.data.source.local.TvShowLocalDataSource
import com.dicoding.upcomingmovies2021.data.source.local.room.MovieDao
import com.dicoding.upcomingmovies2021.data.source.local.room.TvShowDao
import com.dicoding.upcomingmovies2021.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRemoteDataImpl(
        movieDbApiService: TheMovieDbApiService
    ): RemoteDataSourceImpl = RemoteDataSourceImpl(movieDbApiService)

    @Singleton
    @Provides
    fun providesMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource =
        MovieLocalDataSource(movieDao)

    @Singleton
    @Provides
    fun providesTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource =
        TvShowLocalDataSource(tvShowDao)

    @Singleton
    @Provides
    fun providesFilmRepository(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): FilmRepository = FilmRepository(remoteDataSourceImpl)

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieLocalDataSource: MovieLocalDataSource,
        remoteDataSourceImpl: RemoteDataSourceImpl,
        appExecutors: AppExecutors
    ): MovieRepository = MovieRepository(movieLocalDataSource, remoteDataSourceImpl, appExecutors)

    @Singleton
    @Provides
    fun providesTvShowRepository(
        tvShowLocalDataSource: TvShowLocalDataSource,
        remoteDataSourceImpl: RemoteDataSourceImpl,
        appExecutors: AppExecutors
    ): TvShowRepository =
        TvShowRepository(tvShowLocalDataSource, remoteDataSourceImpl, appExecutors)
}