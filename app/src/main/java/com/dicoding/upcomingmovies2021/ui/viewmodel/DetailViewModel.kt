package com.dicoding.upcomingmovies2021.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.repositories.FilmRepository
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val filmRepository: FilmRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val extraId: Int? = savedStateHandle["extraId"]
    private val extraTypeFilm: TypeFilm? = savedStateHandle["extraTypeFilm"]

    private val _movieDetail = MutableLiveData<DetailMovieResponse>()
    private val _tvShowDetail = MutableLiveData<DetailTvShowResponse>()

    private fun getData() {
        when (extraTypeFilm) {
            TypeFilm.Movie -> {
                getDetailMovie()
            }

            TypeFilm.TvShow -> {
                getDetailTvShow()
            }
        }
    }

    private fun getDetailMovie() = viewModelScope.launch {
        extraId?.let { id ->
            filmRepository.getDetailMovie(id).let { response ->
                try {
                    if (response.isSuccessful) {
                        val movieResponse = response.body()
                        movieResponse?.let { movie ->
                            _movieDetail.postValue(movie)
                        }
                    } else {
                        Log.d("movieDb", "Error ${response.code()}: ${response.message()}")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun getDetailTvShow() = viewModelScope.launch {
        extraId?.let { id ->
            filmRepository.getDetailTvShow(id).let { response ->
                try {
                    if (response.isSuccessful) {
                        val tvShowResponse = response.body()
                        tvShowResponse?.let { tvShow ->
                            _tvShowDetail.postValue(tvShow)
                        }
                    } else {
                        Log.d("movieDb", "Error ${response.code()}: ${response.message()}")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    init {
        getData()
    }

    val movieDetail: LiveData<DetailMovieResponse> = _movieDetail
    val tvShowDetail: LiveData<DetailTvShowResponse> = _tvShowDetail
}