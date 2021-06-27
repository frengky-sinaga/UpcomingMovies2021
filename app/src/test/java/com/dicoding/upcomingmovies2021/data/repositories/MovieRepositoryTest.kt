package com.dicoding.upcomingmovies2021.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.upcomingmovies2021.data.source.local.MovieLocalDataSource
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.remote.RemoteDataSourceImpl
import com.dicoding.upcomingmovies2021.utils.AppExecutors
import com.dicoding.upcomingmovies2021.utils.DummyData
import com.dicoding.upcomingmovies2021.utils.LiveDataTestUtil
import com.dicoding.upcomingmovies2021.utils.PagedListUtil
import com.dicoding.upcomingmovies2021.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class MovieRepositoryTest {
    private val dummyMovieResponse = DummyData.generateMovies()
    private val dummyDetailMovieResponse = DummyData.generateDetailMovie()

    private val dummyMovieLocal = DummyData.generateMovieEntities()
    private val dummyIdMovieLocal = dummyMovieLocal[0].movieId
    private val dummyFavoriteMoviesLocal = DummyData.generateDetailMovieEntities()
    private val dummyDetailMovieLocal = dummyFavoriteMoviesLocal[0]

    private val remote = mock(RemoteDataSourceImpl::class.java)
    private val local = mock(MovieLocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val fakeMovieRepository = FakeMovieRepository(local, remote, appExecutors)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `get all movies`() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        whenever(local.getMovies()).thenReturn(dataSourceFactory)
        fakeMovieRepository.getMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(dummyMovieLocal))
        verify(local).getMovies()
        assertNotNull(movieEntity.data)
        assertEquals(dummyMovieResponse.results.size, movieEntity.data?.size)
    }

    @Test
    fun `get detail movie`() {
        val fakeDetailMovie = MutableLiveData<DetailMovieEntity>()
        fakeDetailMovie.value = dummyDetailMovieLocal
        whenever(local.getDetailMovie(dummyIdMovieLocal)).thenReturn(fakeDetailMovie)

        val detailMovieEntity =
            LiveDataTestUtil.getValue(fakeMovieRepository.getDetailMovie(dummyIdMovieLocal))
        verify(local).getDetailMovie(dummyIdMovieLocal)
        assertNotNull(detailMovieEntity.data)
        assertEquals(dummyDetailMovieResponse.id, detailMovieEntity.data?.detailMovieId)
    }

    @Test
    fun `get favorite movies`() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DetailMovieEntity>
        whenever(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        fakeMovieRepository.getFavoriteMovies()

        val favoriteEntities =
            Resource.success(PagedListUtil.mockPagedList(dummyFavoriteMoviesLocal))
        verify(local).getFavoriteMovies()
        assertNotNull(favoriteEntities)
        assertEquals(dummyFavoriteMoviesLocal.size, favoriteEntities.data?.size)
    }
}