package com.dicoding.upcomingmovies2021.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvShowResult
import com.dicoding.upcomingmovies2021.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val filmRepository: FilmRepository
) : ViewModel(){

    private val _tvShowResponse = MutableLiveData<List<TvShowResult>>()
    val tvShowResponse: LiveData<List<TvShowResult>> = _tvShowResponse

    init {
        getTvShows()
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
}