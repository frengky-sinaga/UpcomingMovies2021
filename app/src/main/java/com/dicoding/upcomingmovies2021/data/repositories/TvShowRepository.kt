package com.dicoding.upcomingmovies2021.data.repositories

import androidx.lifecycle.LiveData
import com.dicoding.upcomingmovies2021.data.NetworkBoundResource
import com.dicoding.upcomingmovies2021.data.source.local.TvShowLocalDataSource
import com.dicoding.upcomingmovies2021.data.source.local.entities.CompanyEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.GenreEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.GenreWithTvShows
import com.dicoding.upcomingmovies2021.data.source.remote.RemoteDataSourceImpl
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.DetailTvShowResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvOnTheAirResponse
import com.dicoding.upcomingmovies2021.data.source.remote.network.ApiResponse
import com.dicoding.upcomingmovies2021.utils.AppExecutors
import com.dicoding.upcomingmovies2021.vo.Resource
import javax.inject.Inject

class TvShowRepository @Inject constructor(
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val remoteDataSourceImpl: RemoteDataSourceImpl,
    private val appExecutors: AppExecutors
) : ITvShowRepository {
    override fun getTvShowsOfGenre(tvShowGenreId: Int): LiveData<List<GenreWithTvShows>> =
        tvShowLocalDataSource.getTvShowsOfGenre(tvShowGenreId)

    override fun getTvShows(): LiveData<Resource<List<TvShowEntity>>> {
        return object : NetworkBoundResource<List<TvShowEntity>, TvOnTheAirResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<List<TvShowEntity>> =
                tvShowLocalDataSource.getTvShows()

            override fun shouldFetch(data: List<TvShowEntity>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<TvOnTheAirResponse>> =
                remoteDataSourceImpl.getTvOnTheAir()

            override fun saveCallResult(data: TvOnTheAirResponse) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data.results) {
                    val tvShow = TvShowEntity(
                        tvShowId = response.id,
                        posterPath = response.posterPath,
                        backdropPath = response.backdropPath,
                        name = response.name,
                        originalName = response.originalName,
                        firstAirDate = response.firstAirDate
                    )
                    tvShowList.add(tvShow)
                }
                tvShowLocalDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<Resource<DetailTvShowEntity>> {
        return object :
            NetworkBoundResource<DetailTvShowEntity, DetailTvShowResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<DetailTvShowEntity> =
                tvShowLocalDataSource.getDetailTvShow(tvShowId)

            override fun shouldFetch(data: DetailTvShowEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<DetailTvShowResponse>> =
                remoteDataSourceImpl.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: DetailTvShowResponse) {
                val companyList = ArrayList<CompanyEmbedded>()
                val genreList = ArrayList<GenreEmbedded>()
                for (dataCompany in data.productionCompanies) {
                    val company = CompanyEmbedded(
                        movieCompanyId = dataCompany.id,
                        companyName = dataCompany.name
                    )
                    companyList.add(company)
                }
                for (dataGenre in data.genres) {
                    val genre = GenreEmbedded(
                        genreId = dataGenre.id,
                        genreName = dataGenre.name
                    )
                    genreList.add(genre)
                }
                val detailTvShow = DetailTvShowEntity(
                    detailTvShowId = data.id,
                    backdropPath = data.backdropPath,
                    firstAirDate = data.firstAirDate,
                    name = data.name,
                    originalName = data.originalName,
                    overview = data.overview,
                    posterPath = data.posterPath,
                    status = data.status,
                    genre = genreList,
                    companies = companyList
                )
                tvShowLocalDataSource.insertDetailTvShow(detailTvShow)
            }
        }.asLiveData()
    }

    override fun getFavoriteTvShows(): LiveData<List<DetailTvShowEntity>> =
        tvShowLocalDataSource.getFavoriteTvShows()

    override fun setFavTvShow(detailTvShowEntity: DetailTvShowEntity, newFavState: Boolean) {
        appExecutors.diskIO().execute {
            tvShowLocalDataSource.setFavTvShow(detailTvShowEntity, newFavState)
        }
    }

    override fun deleteAllFavTvShows() {
        appExecutors.diskIO().execute {
            tvShowLocalDataSource.deleteAllFavTvShows()
        }
    }
}