package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.upcomingmovies2021.data.repositories.FilmRepository
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.utils.DummyData
import com.dicoding.upcomingmovies2021.utils.LiveDataTestUtil.getValue
import com.dicoding.upcomingmovies2021.utils.Resource
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private val dummyDetailMovie = DummyData.generateDetailMovie()
    private val dummyDetailTvShow = DummyData.generateDetailTvShow()
    private val dummyIdMovie = dummyDetailMovie.id
    private val dummyIdTvShow = dummyDetailTvShow.id
    private val typeMovie = TypeFilm.Movie
    private val typeTvShow = TypeFilm.TvShow
    private val error = "error"
    private lateinit var viewModel: DetailViewModel

    @Mock
    lateinit var repository: FilmRepository

    @Mock
    lateinit var observerDetailMovie: Observer<Resource<DetailMovieResponse>>

    @Mock
    lateinit var observerDetailTvShow: Observer<Resource<DetailTvShowResponse>>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = DetailViewModel(repository)
    }

    @Test
    fun `test getDetailMovieResult return success`() {
        whenever(repository.getDetailMovie(dummyIdMovie))
            .thenReturn(MutableLiveData(Resource.success(dummyDetailMovie)))
        viewModel.setData(typeMovie, dummyIdMovie)

        verify(repository).getDetailMovie(dummyIdMovie)
        viewModel.movieDetail?.observeForever(observerDetailMovie)
        verify(observerDetailMovie).onChanged(Resource.success(dummyDetailMovie))

        val resource = getValue(viewModel.movieDetail)
        assertNotNull(resource.data)
        assertTrue(resource.status == Resource.Status.SUCCESS)
        assertEquals(dummyDetailMovie, resource.data)
    }

    @Test
    fun `test getDetailMovieResult return error`() {
        whenever(repository.getDetailMovie(dummyIdMovie))
            .thenReturn(MutableLiveData(Resource.error(error)))
        viewModel.setData(typeMovie, dummyIdMovie)

        verify(repository).getDetailMovie(dummyIdMovie)
        viewModel.movieDetail?.observeForever(observerDetailMovie)
        verify(observerDetailMovie).onChanged(Resource.error(error))

        val resource = getValue(viewModel.movieDetail)
        assertTrue(resource.status == Resource.Status.ERROR)
        assertEquals(error, resource.message)
    }

    @Test
    fun `test getDetailMovieResult return empty`() {
        whenever(repository.getDetailMovie(dummyIdMovie))
            .thenReturn(MutableLiveData(Resource.empty()))
        viewModel.setData(typeMovie, dummyIdMovie)

        verify(repository).getDetailMovie(dummyIdMovie)
        viewModel.movieDetail?.observeForever(observerDetailMovie)
        verify(observerDetailMovie).onChanged(Resource.empty())

        val resource = getValue(viewModel.movieDetail)
        assertTrue(resource.status == Resource.Status.EMPTY)
        assertEquals(null, resource.data)
    }

    @Test
    fun `test getDetailTvShowResult return success`() {
        whenever(repository.getDetailTvShow(dummyIdTvShow))
            .thenReturn(MutableLiveData(Resource.success(dummyDetailTvShow)))
        viewModel.setData(typeTvShow, dummyIdTvShow)

        verify(repository).getDetailTvShow(dummyIdTvShow)
        viewModel.tvShowDetail?.observeForever(observerDetailTvShow)
        verify(observerDetailTvShow).onChanged(Resource.success(dummyDetailTvShow))

        val resource = getValue(viewModel.tvShowDetail)
        assertNotNull(resource.data)
        assertTrue(resource.status == Resource.Status.SUCCESS)
        assertEquals(dummyDetailTvShow, resource.data)
    }

    @Test
    fun `test getDetailTvShowResult return error`() {
        whenever(repository.getDetailTvShow(dummyIdTvShow))
            .thenReturn(MutableLiveData(Resource.error(error)))
        viewModel.setData(typeTvShow, dummyIdTvShow)

        verify(repository).getDetailTvShow(dummyIdTvShow)
        viewModel.tvShowDetail?.observeForever(observerDetailTvShow)
        verify(observerDetailTvShow).onChanged(Resource.error(error))

        val resource = getValue(viewModel.tvShowDetail)
        assertTrue(resource.status == Resource.Status.ERROR)
        assertEquals(error, resource.message)
    }

    @Test
    fun `test getDetailTvShowResult return empty`() {
        whenever(repository.getDetailTvShow(dummyIdTvShow))
            .thenReturn(MutableLiveData(Resource.empty()))
        viewModel.setData(typeTvShow, dummyIdTvShow)

        verify(repository).getDetailTvShow(dummyIdTvShow)
        viewModel.tvShowDetail?.observeForever(observerDetailTvShow)
        verify(observerDetailTvShow).onChanged(Resource.empty())

        val resource = getValue(viewModel.tvShowDetail)
        assertTrue(resource.status == Resource.Status.EMPTY)
        assertEquals(null, resource.data)
    }
}