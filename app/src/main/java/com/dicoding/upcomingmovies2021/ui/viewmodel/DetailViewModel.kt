package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.upcomingmovies2021.data.repositories.MovieRepository
import com.dicoding.upcomingmovies2021.data.repositories.TvShowRepository
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import com.dicoding.upcomingmovies2021.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val tvShowRepository: TvShowRepository
) : ViewModel() {

    var movieDetail: LiveData<Resource<DetailMovieEntity>>? = null
    var tvShowDetail: LiveData<Resource<DetailTvShowEntity>>? = null

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
        movieDetail = movieRepository.getDetailMovie(idMovie)
    }

    private fun getDetailTvShow(idTvShow: Int) {
        tvShowDetail = tvShowRepository.getDetailTvShow(idTvShow)
    }
}