package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.upcomingmovies2021.data.repositories.TvShowRepository
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
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
class TvShowViewModelTest {

    private val dummyTvShows = DummyData.generateTvShowEntities()
    private val dummyFavoriteTvShows = DummyData.generateDetailTvEntities()
    private lateinit var viewModel: TvShowViewModel

    @Mock
    lateinit var repository: TvShowRepository

    @Mock
    private lateinit var observerTvShows: Observer<Resource<List<TvShowEntity>>>

    @Mock
    private lateinit var observerDetailTvShow: Observer<List<DetailTvShowEntity>>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun `test getTvShows`() {
        val fakeMovies = MutableLiveData<Resource<List<TvShowEntity>>>()
        fakeMovies.value = Resource.success(dummyTvShows)

        whenever(repository.getTvShows()).thenReturn(fakeMovies)

        val tvShowEntities = viewModel.getTvShows().value?.data
        verify(repository).getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShows.size, tvShowEntities?.size)

        viewModel.getTvShows().observeForever(observerTvShows)
        verify(observerTvShows).onChanged(Resource.success(dummyTvShows))
    }

    @Test
    fun `test getFavTvShows`() {
        val fakeFavoritesTvShows = MutableLiveData<List<DetailTvShowEntity>>()
        fakeFavoritesTvShows.value = dummyFavoriteTvShows

        whenever(repository.getFavoriteTvShows()).thenReturn(fakeFavoritesTvShows)

        val favoritesMovieEntities = viewModel.getFavTvShows().value
        verify(repository).getFavoriteTvShows()
        assertNotNull(favoritesMovieEntities)
        assertEquals(dummyFavoriteTvShows.size, favoritesMovieEntities?.size)

        viewModel.getFavTvShows().observeForever(observerDetailTvShow)
        verify(observerDetailTvShow).onChanged(dummyFavoriteTvShows)
    }
}