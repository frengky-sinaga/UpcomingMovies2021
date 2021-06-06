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
    fun setUp() {
        viewModel = FilmViewModel()
    }

    @Test
    fun `getDataFilm return with the data that sent by others`() {
        val detailFilm = DetailFilmEntity(
            title = "test",
            poster = "link poster",
            genre = listOf(Genre.Action),
            crews = CrewFilmEntity(
                directors = null,
                writers = null,
                stars = listOf("apple"),
                creators = null
            ),
            typeFilm = TypeFilm.TvShow,
            description = "This is a part of test",
            releaseDate = "Unknown",
            link = "unknown"
        )
        viewModel.setDataFilm(detailFilm)

        val value = viewModel.getDataFilm().getOrAwaitValue()
        assertNotNull(value)
        assertEquals(detailFilm.title, value.title)
        assertEquals(detailFilm.crews.directors, value.crews.directors)
        assertEquals(detailFilm.description, value.description)
    }

    @Test
    fun `getDataDummy return with expected data`() {
        val movies = viewModel.getDataDummy(1)
        assertNotNull(movies)
        assertEquals(20, movies.size)
        assertEquals(TypeFilm.Movie, movies[0].typeFilm)

        val tvShow = viewModel.getDataDummy(2)
        assertNotNull(tvShow)
        assertEquals(10, tvShow.size)
        assertEquals(TypeFilm.TvShow, tvShow[0].typeFilm)
    }
}