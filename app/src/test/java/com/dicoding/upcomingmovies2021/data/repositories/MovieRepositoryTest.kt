package com.dicoding.upcomingmovies2021.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dicoding.upcomingmovies2021.data.source.local.MovieLocalDataSource
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.GenreWithMovies
import com.dicoding.upcomingmovies2021.data.source.remote.RemoteDataSourceImpl
import com.dicoding.upcomingmovies2021.utils.AppExecutors
import com.dicoding.upcomingmovies2021.utils.DummyData
import com.dicoding.upcomingmovies2021.utils.LiveDataTestUtil
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
    private val dummyMoviesByGenre = DummyData.generateMoviesByGenre()
    private val dummyGenreIdLocal = dummyDetailMovieLocal.genre[0].genreId

    private val remote = mock(RemoteDataSourceImpl::class.java)
    private val local = mock(MovieLocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val fakeMovieRepository = FakeMovieRepository(local, remote, appExecutors)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `get all movies`(){
        val fakeMovies = MutableLiveData<List<MovieEntity>>()
        fakeMovies.value = dummyMovieLocal
        whenever(local.getMovies()).thenReturn(fakeMovies)

        val movieEntity = LiveDataTestUtil.getValue(fakeMovieRepository.getMovies())
        verify(local).getMovies()
        assertNotNull(movieEntity.data)
        assertEquals(dummyMovieResponse.results.size, movieEntity.data?.size)
    }

    @Test
    fun `get detail movie`(){
        val fakeDetailMovie = MutableLiveData<DetailMovieEntity>()
        fakeDetailMovie.value = dummyDetailMovieLocal
        whenever(local.getDetailMovie(dummyIdMovieLocal)).thenReturn(fakeDetailMovie)

        val detailMovieEntity = LiveDataTestUtil.getValue(fakeMovieRepository.getDetailMovie(dummyIdMovieLocal))
        verify(local).getDetailMovie(dummyIdMovieLocal)
        assertNotNull(detailMovieEntity.data)
        assertEquals(dummyDetailMovieResponse.id, detailMovieEntity.data?.detailMovieId)
    }

    @Test
    fun `get favorite movies`(){
        val fakeFavoriteMovies = MutableLiveData<List<DetailMovieEntity>>()
        fakeFavoriteMovies.value = dummyFavoriteMoviesLocal
        whenever(local.getFavoriteMovies()).thenReturn(fakeFavoriteMovies)

        val favoriteEntities = LiveDataTestUtil.getValue(fakeMovieRepository.getFavoriteMovies())
        verify(local).getFavoriteMovies()
        assertNotNull(favoriteEntities)
        assertEquals(dummyFavoriteMoviesLocal.size, favoriteEntities.size)
    }

    @Test
    fun `get movies by genre`(){
        val fakeMoviesByGenre = MutableLiveData<List<GenreWithMovies>>()
        fakeMoviesByGenre.value = dummyMoviesByGenre
        whenever(local.getMoviesOfGenre(dummyGenreIdLocal)).thenReturn(fakeMoviesByGenre)

        val moviesByGenreEntities = LiveDataTestUtil.getValue(fakeMovieRepository.getMoviesOfGenre(dummyGenreIdLocal))
        verify(local).getMoviesOfGenre(dummyGenreIdLocal)
        assertNotNull(moviesByGenreEntities)
        assertEquals(dummyMoviesByGenre.size, moviesByGenreEntities.size)
    }
}