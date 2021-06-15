package com.dicoding.upcomingmovies2021.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.MovieResult
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvShowResult
import com.dicoding.upcomingmovies2021.repositories.FilmRepository
import com.dicoding.upcomingmovies2021.utils.DataDummy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val filmRepository: FilmRepository
) : ViewModel() {
    fun getDataMovie(): List<DetailFilmEntity> = DataDummy.generateDummyMovie()

    fun getDataTvShow(): List<DetailFilmEntity> = DataDummy.generateDummyTvShow()

    private val _tvShowResponse = MutableLiveData<List<TvShowResult>>()
    val tvShowResponse: LiveData<List<TvShowResult>> = _tvShowResponse

    private val _movieResponse = MutableLiveData<List<MovieResult>>()
    val movieResponse: LiveData<List<MovieResult>> = _movieResponse

    init {
        getTvShows()
        getMovies()
    }

    private fun getTvShows() = viewModelScope.launch {
        filmRepository.getTvShows().let { response ->
            try {
                if (response.isSuccessful) {
                    val arrResult = ArrayList<TvShowResult>()
                    val tvShowResponse = response.body()
                    tvShowResponse?.also {
                        val result = it.results
                        for (tvShow in result) {
                            arrResult.add(tvShow)
                            Log.d("movieDb", tvShow.toString())
                        }
                        _tvShowResponse.postValue(arrResult)
                    }
                } else {
                    Log.d("movieDb", "Error ${response.code()}: ${response.message()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getMovies() = viewModelScope.launch {
        filmRepository.getUpcomingMovies().let { response ->
            try {
                if (response.isSuccessful) {
                    val arrResult = ArrayList<MovieResult>()
                    val movieResponse = response.body()
                    movieResponse?.also {
                        val result = it.results
                        for (movie in result) {
                            arrResult.add(movie)
                            Log.d("movieDb", movie.toString())
                        }
                        _movieResponse.postValue(arrResult)
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