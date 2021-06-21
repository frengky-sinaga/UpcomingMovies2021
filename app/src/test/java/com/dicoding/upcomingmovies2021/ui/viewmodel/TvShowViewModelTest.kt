package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.upcomingmovies2021.data.repositories.FilmRepository
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvOnTheAirResponse
import com.dicoding.upcomingmovies2021.utils.DummyData
import com.dicoding.upcomingmovies2021.utils.LiveDataTestUtil
import com.dicoding.upcomingmovies2021.utils.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private val dummyTvShow = DummyData.generateTvShows()
    private val error = "error"
    private lateinit var viewModel: TvShowViewModel

    @Mock
    lateinit var repository: FilmRepository

    @Mock
    lateinit var observerTvShow: Observer<Resource<TvOnTheAirResponse>>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun `test getTvShowResult return success`() {
        whenever(repository.getTvOnTheAir())
            .thenReturn(MutableLiveData(Resource.success(dummyTvShow)))

        val resource = LiveDataTestUtil.getValue(viewModel.tvShowResult)
        verify(repository).getTvOnTheAir()

        viewModel.tvShowResult.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(Resource.success(dummyTvShow))

        assertNotNull(resource.data)
        assertTrue(resource.status == Resource.Status.SUCCESS)
        assertEquals(dummyTvShow, resource.data)
    }

    @Test
    fun `test getTvShowResult return error`() {
        whenever(repository.getTvOnTheAir())
            .thenReturn(MutableLiveData(Resource.error(error)))

        val resource = LiveDataTestUtil.getValue(viewModel.tvShowResult)
        verify(repository).getTvOnTheAir()

        viewModel.tvShowResult.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(Resource.error(error))

        assertTrue(resource.status == Resource.Status.ERROR)
        assertEquals(error, resource.message)
    }

    @Test
    fun `test getTvShowResult return empty`() {
        whenever(repository.getTvOnTheAir())
            .thenReturn(MutableLiveData(Resource.empty()))

        val resource = LiveDataTestUtil.getValue(viewModel.tvShowResult)
        Mockito.verify(repository).getTvOnTheAir()

        viewModel.tvShowResult.observeForever(observerTvShow)
        verify(observerTvShow).onChanged(Resource.empty())

        assertTrue(resource.status == Resource.Status.EMPTY)
        assertEquals(null, resource.data)
    }
}