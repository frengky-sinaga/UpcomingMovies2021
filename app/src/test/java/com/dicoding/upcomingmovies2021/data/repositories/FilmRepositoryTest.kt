package com.dicoding.upcomingmovies2021.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.upcomingmovies2021.data.source.remote.RemoteDataSourceImpl
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.UpcomingMoviesResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvOnTheAirResponse
import com.dicoding.upcomingmovies2021.data.source.remote.network.ApiResponse
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
class FilmRepositoryTest {
    private val dummyMovies = DummyData.generateMovies()
    private val dummyTvShow = DummyData.generateTvShows()
    private val dummyDetailMovie = DummyData.generateDetailMovie()
    private val dummyDetailTvShow = DummyData.generateDetailTvShow()
    private val dummyIdMovie = dummyDetailMovie.id
    private val dummyIdTvShow = dummyDetailTvShow.id
    private val error = "error"
    private lateinit var repositoryFake: FilmRepositoryFake

    @Mock
    lateinit var remoteDataSourceImpl: RemoteDataSourceImpl

    @Mock
    lateinit var observerResourceMovie: Observer<Resource<UpcomingMoviesResponse>>

    @Mock
    lateinit var observerResourceTvShow: Observer<Resource<TvOnTheAirResponse>>

    @Mock
    lateinit var observerResourceDetailMovie: Observer<Resource<DetailMovieResponse>>

    @Mock
    lateinit var observerResourceDetailTvShow: Observer<Resource<DetailTvShowResponse>>

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        repositoryFake = FilmRepositoryFake(remoteDataSourceImpl)
    }

    @Test
    fun `test getUpcomingMovies return success`() {
        whenever(remoteDataSourceImpl.getUpcomingMovies())
            .thenReturn(MutableLiveData(ApiResponse.Success(dummyMovies)))

        val resource = getValue(repositoryFake.getUpcomingMovies())
        verify(remoteDataSourceImpl).getUpcomingMovies()

        repositoryFake.getUpcomingMovies().observeForever(observerResourceMovie)
        verify(observerResourceMovie).onChanged(Resource.success(dummyMovies))

        assertNotNull(resource.data)
        assertTrue(resource.status == Resource.Status.SUCCESS)
        assertEquals(dummyMovies, resource.data)
    }

    @Test
    fun `test getUpcomingMovies return error`() {
        whenever(remoteDataSourceImpl.getUpcomingMovies())
            .thenReturn(MutableLiveData(ApiResponse.Error(error)))

        val resource = getValue(repositoryFake.getUpcomingMovies())
        verify(remoteDataSourceImpl).getUpcomingMovies()

        repositoryFake.getUpcomingMovies().observeForever(observerResourceMovie)
        verify(observerResourceMovie).onChanged(Resource.error(error))

        assertTrue(resource.status == Resource.Status.ERROR)
        assertEquals(error, resource.message)
    }

    @Test
    fun `test getUpcomingMovies return empty`() {
        whenever(remoteDataSourceImpl.getUpcomingMovies())
            .thenReturn(MutableLiveData(ApiResponse.Empty(null)))

        val resource = getValue(repositoryFake.getUpcomingMovies())
        verify(remoteDataSourceImpl).getUpcomingMovies()

        repositoryFake.getUpcomingMovies().observeForever(observerResourceMovie)
        verify(observerResourceMovie).onChanged(Resource.empty())

        assertTrue(resource.status == Resource.Status.EMPTY)
        assertEquals(null, resource.data)
    }

    @Test
    fun `test getTvOnTheAir return success`() {
        whenever(remoteDataSourceImpl.getTvOnTheAir())
            .thenReturn(MutableLiveData(ApiResponse.Success(dummyTvShow)))

        val resource = getValue(repositoryFake.getTvOnTheAir())
        verify(remoteDataSourceImpl).getTvOnTheAir()

        repositoryFake.getTvOnTheAir().observeForever(observerResourceTvShow)
        verify(observerResourceTvShow).onChanged(Resource.success(dummyTvShow))

        assertNotNull(resource.data)
        assertTrue(resource.status == Resource.Status.SUCCESS)
        assertEquals(dummyTvShow, resource.data)
    }

    @Test
    fun `test getTvOnTheAir return error`() {
        whenever(remoteDataSourceImpl.getTvOnTheAir())
            .thenReturn(MutableLiveData(ApiResponse.Error(error)))

        val resource = getValue(repositoryFake.getTvOnTheAir())
        verify(remoteDataSourceImpl).getTvOnTheAir()

        repositoryFake.getTvOnTheAir().observeForever(observerResourceTvShow)
        verify(observerResourceTvShow).onChanged(Resource.error(error))

        assertTrue(resource.status == Resource.Status.ERROR)
        assertEquals(error, resource.message)
    }

    @Test
    fun `test getTvOnTheAir return empty`() {
        whenever(remoteDataSourceImpl.getTvOnTheAir())
            .thenReturn(MutableLiveData(ApiResponse.Empty(null)))

        val resource = getValue(repositoryFake.getTvOnTheAir())
        verify(remoteDataSourceImpl).getTvOnTheAir()

        repositoryFake.getTvOnTheAir().observeForever(observerResourceTvShow)
        verify(observerResourceTvShow).onChanged(Resource.empty())

        assertTrue(resource.status == Resource.Status.EMPTY)
        assertEquals(null, resource.data)
    }

    @Test
    fun `test getDetailMovie return success`() {
        whenever(remoteDataSourceImpl.getDetailMovie(dummyIdMovie))
            .thenReturn(MutableLiveData(ApiResponse.Success(dummyDetailMovie)))

        val resource = getValue(repositoryFake.getDetailMovie(dummyIdMovie))
        verify(remoteDataSourceImpl).getDetailMovie(dummyIdMovie)

        repositoryFake.getDetailMovie(dummyIdMovie).observeForever(observerResourceDetailMovie)
        verify(observerResourceDetailMovie).onChanged(Resource.success(dummyDetailMovie))

        assertNotNull(resource.data)
        assertTrue(resource.status == Resource.Status.SUCCESS)
        assertEquals(dummyDetailMovie, resource.data)
    }

    @Test
    fun `test getDetailMovie return error`() {
        whenever(remoteDataSourceImpl.getDetailMovie(dummyIdMovie))
            .thenReturn(MutableLiveData(ApiResponse.Error(error)))

        val resource = getValue(repositoryFake.getDetailMovie(dummyIdMovie))
        verify(remoteDataSourceImpl).getDetailMovie(dummyIdMovie)

        repositoryFake.getDetailMovie(dummyIdMovie).observeForever(observerResourceDetailMovie)
        verify(observerResourceDetailMovie).onChanged(Resource.error(error))

        assertTrue(resource.status == Resource.Status.ERROR)
        assertEquals(error, resource.message)
    }

    @Test
    fun `test getDetailMovie return empty`() {
        whenever(remoteDataSourceImpl.getDetailMovie(dummyIdMovie))
            .thenReturn(MutableLiveData(ApiResponse.Empty(null)))

        val resource = getValue(repositoryFake.getDetailMovie(dummyIdMovie))
        verify(remoteDataSourceImpl).getDetailMovie(dummyIdMovie)

        repositoryFake.getDetailMovie(dummyIdMovie).observeForever(observerResourceDetailMovie)
        verify(observerResourceDetailMovie).onChanged(Resource.empty())

        assertTrue(resource.status == Resource.Status.EMPTY)
        assertEquals(null, resource.data)
    }

    @Test
    fun `test getDetailTvShow return success`() {
        whenever(remoteDataSourceImpl.getDetailTvShow(dummyIdTvShow))
            .thenReturn(MutableLiveData(ApiResponse.Success(dummyDetailTvShow)))

        val resource = getValue(repositoryFake.getDetailTvShow(dummyIdTvShow))
        verify(remoteDataSourceImpl).getDetailTvShow(dummyIdTvShow)

        repositoryFake.getDetailTvShow(dummyIdTvShow).observeForever(observerResourceDetailTvShow)
        verify(observerResourceDetailTvShow).onChanged(Resource.success(dummyDetailTvShow))

        assertNotNull(resource.data)
        assertTrue(resource.status == Resource.Status.SUCCESS)
        assertEquals(dummyDetailTvShow, resource.data)
    }

    @Test
    fun `test getDetailTvShow return error`() {
        whenever(remoteDataSourceImpl.getDetailTvShow(dummyIdTvShow))
            .thenReturn(MutableLiveData(ApiResponse.Error(error)))

        val resource = getValue(repositoryFake.getDetailTvShow(dummyIdTvShow))
        verify(remoteDataSourceImpl).getDetailTvShow(dummyIdTvShow)

        repositoryFake.getDetailTvShow(dummyIdTvShow).observeForever(observerResourceDetailTvShow)
        verify(observerResourceDetailTvShow).onChanged(Resource.error(error))

        assertTrue(resource.status == Resource.Status.ERROR)
        assertEquals(error, resource.message)
    }

    @Test
    fun `test getDetailTvShow return empty`() {
        whenever(remoteDataSourceImpl.getDetailTvShow(dummyIdTvShow))
            .thenReturn(MutableLiveData(ApiResponse.Empty()))

        val resource = getValue(repositoryFake.getDetailTvShow(dummyIdTvShow))
        verify(remoteDataSourceImpl).getDetailTvShow(dummyIdTvShow)

        repositoryFake.getDetailTvShow(dummyIdTvShow).observeForever(observerResourceDetailTvShow)
        verify(observerResourceDetailTvShow).onChanged(Resource.empty())

        assertTrue(resource.status == Resource.Status.EMPTY)
        assertEquals(null, resource.data)
    }
}