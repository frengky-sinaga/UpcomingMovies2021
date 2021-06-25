package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.upcomingmovies2021.data.repositories.FilmRepository
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.UpcomingMoviesResponse
import com.dicoding.upcomingmovies2021.utils.DummyData
import com.dicoding.upcomingmovies2021.utils.LiveDataTestUtil.getValue
import com.dicoding.upcomingmovies2021.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private val dummyMovies = DummyData.generateMovies()
    private val error = "error"
    private lateinit var viewModel: MovieViewModel

    @Mock
    lateinit var repository: FilmRepository

    @Mock
    lateinit var observerMovie: Observer<Resource<UpcomingMoviesResponse>>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun `test getMovieResult return success`() {
        whenever(repository.getUpcomingMovies())
            .thenReturn(MutableLiveData(Resource.success(dummyMovies)))

        val resource = getValue(viewModel.movieResult)
        verify(repository).getUpcomingMovies()

        viewModel.movieResult.observeForever(observerMovie)
        verify(observerMovie).onChanged(Resource.success(dummyMovies))

        assertNotNull(resource.data)
        assertTrue(resource.status == Resource.Status.SUCCESS)
        assertEquals(dummyMovies, resource.data)
    }

    @Test
    fun `test getMovieResult return error`() {
        whenever(repository.getUpcomingMovies())
            .thenReturn(MutableLiveData(Resource.error(error)))

        val resource = getValue(viewModel.movieResult)
        verify(repository).getUpcomingMovies()

        viewModel.movieResult.observeForever(observerMovie)
        verify(observerMovie).onChanged(Resource.error(error))

        assertTrue(resource.status == Resource.Status.ERROR)
        assertEquals(error, resource.message)
    }

    @Test
    fun `test getMovieResult return empty`() {
        whenever(repository.getUpcomingMovies())
            .thenReturn(MutableLiveData(Resource.empty()))

        val resource = getValue(viewModel.movieResult)
        verify(repository).getUpcomingMovies()

        viewModel.movieResult.observeForever(observerMovie)
        verify(observerMovie).onChanged(Resource.empty())

        assertTrue(resource.status == Resource.Status.EMPTY)
        assertEquals(null, resource.data)
    }
}