package com.dicoding.upcomingmovies2021.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.dicoding.upcomingmovies2021.data.source.remote.RemoteDataSourceImpl
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.UpcomingMoviesResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvOnTheAirResponse
import com.dicoding.upcomingmovies2021.data.source.remote.network.ApiResponse
import com.dicoding.upcomingmovies2021.vo.Resource

class FilmRepositoryFake(private val remoteDataSource: RemoteDataSourceImpl) {

    fun getUpcomingMovies(): LiveData<Resource<UpcomingMoviesResponse>> {
        return result(
            MediatorLiveData<Resource<UpcomingMoviesResponse>>(),
            remoteDataSource.getUpcomingMovies()
        )
    }

    fun getTvOnTheAir(): LiveData<Resource<TvOnTheAirResponse>> {
        return result(
            MediatorLiveData<Resource<TvOnTheAirResponse>>(),
            remoteDataSource.getTvOnTheAir()
        )
    }

    fun getDetailMovie(movieId: Int): LiveData<Resource<DetailMovieResponse>> {
        return result(
            MediatorLiveData<Resource<DetailMovieResponse>>(),
            remoteDataSource.getDetailMovie(movieId)
        )
    }

    fun getDetailTvShow(tvShowId: Int): LiveData<Resource<DetailTvShowResponse>> {
        return result(
            MediatorLiveData<Resource<DetailTvShowResponse>>(),
            remoteDataSource.getDetailTvShow(tvShowId)
        )
    }

    private fun <T> result(
        result: MediatorLiveData<Resource<T>>, response: LiveData<ApiResponse<T>>
    ): LiveData<Resource<T>> {
        result.postValue(Resource.loading())
        result.addSource(response) {
            result.removeSource(response)
            when (it) {
                is ApiResponse.Success -> result.postValue(Resource.success(it.data))
                is ApiResponse.Error -> result.postValue(Resource.error(it.errorMessage))
                is ApiResponse.Empty -> result.postValue(Resource.empty())
            }
        }
        return result
    }
}