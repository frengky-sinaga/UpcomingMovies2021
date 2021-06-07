package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.utils.DataDummy

class DetailViewModel : ViewModel() {

    private fun getListMovie(): List<DetailFilmEntity> = DataDummy.generateDummyMovie()
    private fun getListTvShow(): List<DetailFilmEntity> = DataDummy.generateDummyTvShow()

    fun getDetailMovieById(movieId: String): DetailFilmEntity {
        lateinit var result: DetailFilmEntity
        val listMovie = getListMovie()
        for (movie in listMovie) {
            if (movie.idFilm == movieId) {
                result = movie
                break
            }
        }
        return result
    }

    fun getDetailTvShowById(tvShowId: String): DetailFilmEntity {
        lateinit var result: DetailFilmEntity
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow) {
            if (tvShow.idFilm == tvShowId) {
                result = tvShow
                break
            }
        }
        return result
    }
}