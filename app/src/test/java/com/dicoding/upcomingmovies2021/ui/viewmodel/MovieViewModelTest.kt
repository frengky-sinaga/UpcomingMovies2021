package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.upcomingmovies2021.data.repositories.MovieRepository
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
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
    private lateinit var viewModel: MovieViewModel

    @Mock
    lateinit var repository: MovieRepository

    @Mock
    private lateinit var observerMovies: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var observerDetailMovie: Observer<PagedList<DetailMovieEntity>>

    @Mock
    private lateinit var pagedListMovie: PagedList<MovieEntity>

    @Mock
    private lateinit var pagedListFavMovie: PagedList<DetailMovieEntity>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun `test getMovies`() {
        val dummyData = Resource.success(pagedListMovie)
        whenever(dummyData.data?.size).thenReturn(5)

        val fakeMovies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        fakeMovies.value = dummyData

        whenever(repository.getMovies()).thenReturn(fakeMovies)

        val movieEntities = viewModel.getMovies().value?.data
        verify(repository).getMovies()
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getMovies().observeForever(observerMovies)
        verify(observerMovies).onChanged(dummyData)
    }

    @Test
    fun `test getFavMovies`() {
        val dummyData = pagedListFavMovie
        whenever(dummyData.size).thenReturn(5)

        val fakeFavoritesMovies = MutableLiveData<PagedList<DetailMovieEntity>>()
        fakeFavoritesMovies.value = dummyData

        whenever(repository.getFavoriteMovies()).thenReturn(fakeFavoritesMovies)

        val favoritesMovieEntities = viewModel.getFavMovies().value
        verify(repository).getFavoriteMovies()
        assertNotNull(favoritesMovieEntities)
        assertEquals(5, favoritesMovieEntities?.size)

        viewModel.getFavMovies().observeForever(observerDetailMovie)
        verify(observerDetailMovie).onChanged(dummyData)
    }
}