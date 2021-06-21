package com.dicoding.upcomingmovies2021.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.UpcomingMoviesResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvOnTheAirResponse
import com.dicoding.upcomingmovies2021.data.source.remote.network.ApiResponse
import com.dicoding.upcomingmovies2021.data.source.remote.network.TheMovieDbApiService
import com.dicoding.upcomingmovies2021.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val movieDbApiService: TheMovieDbApiService
) : RemoteDataSource {

    override fun getUpcomingMovies(): LiveData<ApiResponse<UpcomingMoviesResponse>> {
        val data = MutableLiveData<ApiResponse<UpcomingMoviesResponse>>()
        movieDbApiService.getUpcomingMovie().enqueue(enqueueCallback(data))
        return data
    }

    override fun getTvOnTheAir(): LiveData<ApiResponse<TvOnTheAirResponse>> {
        val data = MutableLiveData<ApiResponse<TvOnTheAirResponse>>()
        movieDbApiService.getTvShowOnTheAir().enqueue(enqueueCallback(data))
        return data
    }

    override fun getDetailMovie(id: Int): LiveData<ApiResponse<DetailMovieResponse>> {
        val data = MutableLiveData<ApiResponse<DetailMovieResponse>>()
        movieDbApiService.getDetailMovie(id).enqueue(enqueueCallback(data))
        return data
    }

    override fun getDetailTvShow(id: Int): LiveData<ApiResponse<DetailTvShowResponse>> {
        val data = MutableLiveData<ApiResponse<DetailTvShowResponse>>()
        movieDbApiService.getDetailTvShow(id).enqueue(enqueueCallback(data))
        return data
    }

    private fun <T> enqueueCallback(mutableLiveData: MutableLiveData<ApiResponse<T>>): Callback<T?> {
        EspressoIdlingResource.increment()
        return object : Callback<T?> {
            override fun onResponse(call: Call<T?>, response: Response<T?>) {
                val dataResponse = response.body()
                mutableLiveData.postValue(
                    if (dataResponse != null) ApiResponse.Success(dataResponse)
                    else ApiResponse.Empty()
                )
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<T?>, t: Throwable) {
                mutableLiveData.postValue(ApiResponse.Error(t.message.toString()))
                EspressoIdlingResource.decrement()
            }
        }
    }
}