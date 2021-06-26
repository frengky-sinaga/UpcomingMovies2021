package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.upcomingmovies2021.data.repositories.MovieRepository
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.utils.DummyData
import com.dicoding.upcomingmovies2021.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
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
    private val dummyMovies = DummyData.generateMovieEntities()
    private val dummyFavoriteMovies = DummyData.generateDetailMovieEntities()
    private lateinit var viewModel: MovieViewModel

    @Mock
    lateinit var repository: MovieRepository

    @Mock
    private lateinit var observerMovies: Observer<Resource<List<MovieEntity>>>

    @Mock
    private lateinit var observerDetailMovie: Observer<List<DetailMovieEntity>>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun `test getMovies`() {
        val fakeMovies = MutableLiveData<Resource<List<MovieEntity>>>()
        fakeMovies.value = Resource.success(dummyMovies)

        whenever(repository.getMovies()).thenReturn(fakeMovies)

        val movieEntities = viewModel.getMovies().value?.data
        verify(repository).getMovies()
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.size, movieEntities?.size)

        viewModel.getMovies().observeForever(observerMovies)
        verify(observerMovies).onChanged(Resource.success(dummyMovies))
    }

    @Test
    fun `test getFavMovies`() {
        val fakeFavoritesMovies = MutableLiveData<List<DetailMovieEntity>>()
        fakeFavoritesMovies.value = dummyFavoriteMovies

        whenever(repository.getFavoriteMovies()).thenReturn(fakeFavoritesMovies)

        val favoritesMovieEntities = viewModel.getFavMovies().value
        verify(repository).getFavoriteMovies()
        assertNotNull(favoritesMovieEntities)
        assertEquals(dummyFavoriteMovies.size, favoritesMovieEntities?.size)

        viewModel.getFavMovies().observeForever(observerDetailMovie)
        verify(observerDetailMovie).onChanged(dummyFavoriteMovies)
    }
}