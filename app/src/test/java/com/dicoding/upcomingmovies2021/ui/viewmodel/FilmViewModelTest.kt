package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.upcomingmovies2021.data.CrewFilmEntity
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.utils.Genre
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.junit.Assert.*

class FilmViewModelTest {

    private lateinit var viewModel: FilmViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        viewModel = FilmViewModel()
    }

    @Test
    fun `getDataFilm return with the data that sent by others`() {
        val detailFilm = DetailFilmEntity(
            title = "test",
            poster = "link poster",
            genre = listOf(Genre.Action),
            crews = CrewFilmEntity(
                director = null,
                writers = null,
                stars = listOf("apple")
            ),
            typeFilm = TypeFilm.TvShow,
            description = "This is a part of test",
            releaseDate = "Unknown",
            link = "unknown"
        )
        viewModel.setDataFilm(detailFilm)

        val value = viewModel.getDataFilm().getOrAwaitValue()
        assertNotNull(value)
        assertEquals(value.title, detailFilm.title)
        assertEquals(value.crews.director, detailFilm.crews.director)
        assertEquals(value.description, detailFilm.description)
    }

    @Test
    fun getDataDummy() {
        val filmEntities = viewModel.getDataDummy(1)
        assertNotNull(filmEntities)
        assertEquals(2, filmEntities.size)
    }
}