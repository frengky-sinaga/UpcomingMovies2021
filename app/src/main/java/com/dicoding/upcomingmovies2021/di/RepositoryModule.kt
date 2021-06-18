package com.dicoding.upcomingmovies2021.di

import com.dicoding.upcomingmovies2021.data.source.remote.RemoteDataSourceImpl
import com.dicoding.upcomingmovies2021.data.source.remote.network.TheMovieDbApiService
import com.dicoding.upcomingmovies2021.data.repositories.FilmRepository
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
    fun providesFilmRepository(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): FilmRepository = FilmRepository(remoteDataSourceImpl)
}