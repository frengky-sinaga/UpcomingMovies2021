package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.repositories.FilmRepository
import com.dicoding.upcomingmovies2021.utils.Resource
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val filmRepository: FilmRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val extraId: Int? = savedStateHandle["extraId"]
    private val extraTypeFilm: TypeFilm? = savedStateHandle["extraTypeFilm"]

    var movieDetail: LiveData<Resource<DetailMovieResponse>>? = null
    var tvShowDetail: LiveData<Resource<DetailTvShowResponse>>? = null

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

    init {
        getData()
    }

    private fun getDetailMovie() {
        movieDetail = extraId?.let { filmRepository.getDetailMovie(it) }
    }

    private fun getDetailTvShow() {
        tvShowDetail = extraId?.let { filmRepository.getDetailTvShow(it) }
    }

}