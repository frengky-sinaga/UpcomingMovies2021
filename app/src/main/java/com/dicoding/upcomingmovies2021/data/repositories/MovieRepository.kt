package com.dicoding.upcomingmovies2021.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.upcomingmovies2021.data.NetworkBoundResource
import com.dicoding.upcomingmovies2021.data.source.local.MovieLocalDataSource
import com.dicoding.upcomingmovies2021.data.source.local.entities.CompanyEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.GenreEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.remote.RemoteDataSourceImpl
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.DetailMovieResponse
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.UpcomingMoviesResponse
import com.dicoding.upcomingmovies2021.data.source.remote.network.ApiResponse
import com.dicoding.upcomingmovies2021.utils.AppExecutors
import com.dicoding.upcomingmovies2021.vo.Resource
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieLocalDataSource: MovieLocalDataSource,
    private val remoteDataSourceImpl: RemoteDataSourceImpl,
    private val appExecutors: AppExecutors
) : IMovieRepository {
    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, UpcomingMoviesResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(6)
                    .setPageSize(6)
                    .build()
                return LivePagedListBuilder(movieLocalDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean = data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<UpcomingMoviesResponse>> =
                remoteDataSourceImpl.getUpcomingMovies()

            override fun saveCallResult(data: UpcomingMoviesResponse) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data.results) {
                    val movie = MovieEntity(
                        movieId = response.id,
                        backdropPath = response.backdropPath,
                        originalTitle = response.originalTitle,
                        posterPath = response.posterPath,
                        releaseDate = response.releaseDate,
                        title = response.title
                    )
                    movieList.add(movie)
                }
                movieLocalDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<DetailMovieEntity>> {
        return object : NetworkBoundResource<DetailMovieEntity, DetailMovieResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<DetailMovieEntity> =
                movieLocalDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: DetailMovieEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<DetailMovieResponse>> =
                remoteDataSourceImpl.getDetailMovie(movieId)

            override fun saveCallResult(data: DetailMovieResponse) {
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
                val detailMovie = DetailMovieEntity(
                    detailMovieId = data.id,
                    backdropPath = data.backdropPath,
                    originalTitle = data.originalTitle,
                    title = data.title,
                    releaseDate = data.releaseDate,
                    posterPath = data.posterPath,
                    companies = companyList,
                    status = data.status,
                    overview = data.overview,
                    genre = genreList
                )
                movieLocalDataSource.insertDetailMovie(detailMovie)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<DetailMovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(6)
            .setPageSize(6)
            .build()
        return LivePagedListBuilder(movieLocalDataSource.getFavoriteMovies(), config).build()
    }

    override fun setFavMovie(detailMovieEntity: DetailMovieEntity, newFavState: Boolean) {
        appExecutors.diskIO().execute {
            movieLocalDataSource.setFavMovie(detailMovieEntity, newFavState)
        }
    }

    override fun deleteAllFavMovies() {
        appExecutors.diskIO().execute {
            movieLocalDataSource.deleteAllFavMovies()
        }
    }
}