package com.dicoding.upcomingmovies2021.data.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.upcomingmovies2021.data.source.local.TvShowLocalDataSource
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
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

class TvShowsRepositoryTest {
    private val dummyTvShowResponse = DummyData.generateTvShows()
    private val dummyDetailTvShowResponse = DummyData.generateDetailTvShow()

    private val dummyTvShowLocal = DummyData.generateTvShowEntities()
    private val dummyIdTvShowLocal = dummyTvShowLocal[0].tvShowId
    private val dummyFavoriteTvShowsLocal = DummyData.generateDetailTvEntities()
    private val dummyDetailTvShowLocal = dummyFavoriteTvShowsLocal[0]

    private val remote = mock(RemoteDataSourceImpl::class.java)
    private val local = mock(TvShowLocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val fakeTvShowRepository = FakeTvShowRepository(local, remote, appExecutors)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `get all tvShows`() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        whenever(local.getTvShows()).thenReturn(dataSourceFactory)
        fakeTvShowRepository.getTvShows()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(dummyTvShowLocal))
        verify(local).getTvShows()
        assertNotNull(tvShowEntity.data)
        assertEquals(dummyTvShowResponse.results.size, tvShowEntity.data?.size)
    }

    @Test
    fun `get detail tvShow`() {
        val fakeDetailShow = MutableLiveData<DetailTvShowEntity>()
        fakeDetailShow.value = dummyDetailTvShowLocal
        whenever(local.getDetailTvShow(dummyIdTvShowLocal)).thenReturn(fakeDetailShow)

        val detailTvShowEntity =
            LiveDataTestUtil.getValue(fakeTvShowRepository.getDetailTvShow(dummyIdTvShowLocal))
        verify(local).getDetailTvShow(dummyIdTvShowLocal)
        assertNotNull(detailTvShowEntity.data)
        assertEquals(dummyDetailTvShowResponse.id, detailTvShowEntity.data?.detailTvShowId)
    }

    @Test
    fun `get favorite tvShows`() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, DetailTvShowEntity>
        whenever(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        fakeTvShowRepository.getFavoriteTvShows()

        val favoriteEntities =
            Resource.success(PagedListUtil.mockPagedList(dummyFavoriteTvShowsLocal))
        verify(local).getFavoriteTvShows()
        assertNotNull(favoriteEntities)
        assertEquals(dummyFavoriteTvShowsLocal.size, favoriteEntities.data?.size)
    }
}