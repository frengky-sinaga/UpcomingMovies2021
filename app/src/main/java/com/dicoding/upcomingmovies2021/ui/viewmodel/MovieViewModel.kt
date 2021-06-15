package com.dicoding.upcomingmovies2021.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.MovieResult
import com.dicoding.upcomingmovies2021.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val filmRepository: FilmRepository
): ViewModel() {

    private val _movieResponse = MutableLiveData<List<MovieResult>>()
    val movieResponse: LiveData<List<MovieResult>> = _movieResponse

    init {
        getMovies()
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