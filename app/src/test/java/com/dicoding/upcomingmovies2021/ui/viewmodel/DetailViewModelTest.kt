package com.dicoding.upcomingmovies2021.ui.viewmodel

import com.dicoding.upcomingmovies2021.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest{
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShow()[0]
    private val movieId = dummyMovie.idFilm
    private val tvShowId = dummyTvShow.idFilm

    @Before
    fun setup(){
        viewModel = DetailViewModel()
    }

    @Test
    fun getDetailMovieById() {
        val dataMovie = viewModel.getDetailMovieById(movieId)
        assertNotNull(dataMovie)
        assertEquals(dummyMovie.title, dataMovie.title)
        assertEquals(dummyMovie.releaseDate, dataMovie.releaseDate)
        assertEquals(dummyMovie.description, dataMovie.description)
        assertEquals(dummyMovie.crews, dataMovie.crews)
        assertEquals(dummyMovie.genre, dataMovie.genre)
        assertEquals(dummyMovie.poster, dataMovie.poster)
        assertEquals(dummyMovie.link, dataMovie.link)
    }

    @Test
    fun getDetailTvShowById() {
        val dataTvShow = viewModel.getDetailTvShowById(tvShowId)
        assertNotNull(dataTvShow)
        assertEquals(dummyTvShow.title, dataTvShow.title)
        assertEquals(dummyTvShow.releaseDate, dataTvShow.releaseDate)
        assertEquals(dummyTvShow.description, dataTvShow.description)
        assertEquals(dummyTvShow.crews, dataTvShow.crews)
        assertEquals(dummyTvShow.genre, dataTvShow.genre)
        assertEquals(dummyTvShow.poster, dataTvShow.poster)
        assertEquals(dummyTvShow.link, dataTvShow.link)
    }
}