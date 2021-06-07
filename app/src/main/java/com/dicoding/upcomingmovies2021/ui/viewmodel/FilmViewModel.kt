package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.utils.DataDummy

class FilmViewModel : ViewModel() {
    fun getDataMovie(): List<DetailFilmEntity> = DataDummy.generateDummyMovie()

    fun getDataTvShow(): List<DetailFilmEntity> = DataDummy.generateDummyTvShow()
}