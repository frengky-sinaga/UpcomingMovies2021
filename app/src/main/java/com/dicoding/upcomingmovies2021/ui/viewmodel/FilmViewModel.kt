package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.utils.DataDummy

class FilmViewModel : ViewModel() {
    private var dataFilm = MutableLiveData<DetailFilmEntity>()

    fun setDataFilm(data: DetailFilmEntity) {
        dataFilm.value = data
    }

    fun getDataFilm(): LiveData<DetailFilmEntity> = dataFilm

    fun getDataDummy(index: Int): List<DetailFilmEntity> =
        if (index == 1) DataDummy.generateDummyMovie() else DataDummy.generateDummyTvShow()

    fun getDataMovie(): List<DetailFilmEntity> = DataDummy.generateDummyMovie()

    fun getDataTvShow(): List<DetailFilmEntity> = DataDummy.generateDummyTvShow()
}