package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.data.repositories.FilmRepository
import com.dicoding.upcomingmovies2021.vo.Resource
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val filmRepository: FilmRepository
) : ViewModel() {

    var movieDetail: LiveData<Resource<DetailMovieResponse>>? = null
    var tvShowDetail: LiveData<Resource<DetailTvShowResponse>>? = null

    fun setData(typeFilm: TypeFilm, id: Int) {
        when (typeFilm) {
            TypeFilm.Movie -> {
                getDetailMovie(id)
            }

            TypeFilm.TvShow -> {
                getDetailTvShow(id)
            }
        }
    }

    private fun getDetailMovie(idMovie: Int) {
        movieDetail = filmRepository.getDetailMovie(idMovie)
    }

    private fun getDetailTvShow(idTvShow: Int) {
        tvShowDetail = filmRepository.getDetailTvShow(idTvShow)
    }
}