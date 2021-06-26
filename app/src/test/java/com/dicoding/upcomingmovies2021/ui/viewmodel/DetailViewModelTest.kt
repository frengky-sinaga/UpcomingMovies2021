package com.dicoding.upcomingmovies2021.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.upcomingmovies2021.data.repositories.MovieRepository
import com.dicoding.upcomingmovies2021.data.repositories.TvShowRepository
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.utils.DummyData
import com.dicoding.upcomingmovies2021.utils.TypeFilm
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
class DetailViewModelTest {

    private val dummyDetailMovie = DummyData.generateDetailMovieEntities()[0]
    private val dummyDetailTvShow = DummyData.generateDetailTvEntities()[0]
    private val dummyIdMovie = dummyDetailMovie.detailMovieId
    private val dummyIdTvShow = dummyDetailTvShow.detailTvShowId
    private val typeMovie = TypeFilm.Movie
    private val typeTvShow = TypeFilm.TvShow
    private lateinit var viewModel: DetailViewModel

    @Mock
    lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var tvShowRepository: TvShowRepository

    @Mock
    lateinit var observerDetailMovie: Observer<Resource<DetailMovieEntity>>

    @Mock
    lateinit var observerDetailTvShow: Observer<Resource<DetailTvShowEntity>>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository, tvShowRepository)
    }

    @Test
    fun `test get detail movie`() {
        val fakeDetailMovie = MutableLiveData<Resource<DetailMovieEntity>>()
        fakeDetailMovie.value = Resource.success(dummyDetailMovie)

        whenever(movieRepository.getDetailMovie(dummyIdMovie)).thenReturn(fakeDetailMovie)
        viewModel.setData(typeMovie, dummyIdMovie)

        verify(movieRepository).getDetailMovie(dummyIdMovie)
        viewModel.movieDetail?.observeForever(observerDetailMovie)
        verify(observerDetailMovie).onChanged(Resource.success(dummyDetailMovie))

        val detailMovieEntity = viewModel.movieDetail?.value?.data
        assertNotNull(detailMovieEntity)
        assertEquals(dummyDetailMovie, detailMovieEntity)
    }

    @Test
    fun `test get detail tvShow`() {
        val fakeDetailTvShow = MutableLiveData<Resource<DetailTvShowEntity>>()
        fakeDetailTvShow.value = Resource.success(dummyDetailTvShow)

        whenever(tvShowRepository.getDetailTvShow(dummyIdTvShow)).thenReturn(fakeDetailTvShow)
        viewModel.setData(typeTvShow, dummyIdTvShow)

        verify(tvShowRepository).getDetailTvShow(dummyIdTvShow)
        viewModel.tvShowDetail?.observeForever(observerDetailTvShow)
        verify(observerDetailTvShow).onChanged(Resource.success(dummyDetailTvShow))

        val detailTvShowEntity = viewModel.tvShowDetail?.value?.data
        assertNotNull(detailTvShowEntity)
        assertEquals(dummyDetailTvShow, detailTvShowEntity)
    }
}