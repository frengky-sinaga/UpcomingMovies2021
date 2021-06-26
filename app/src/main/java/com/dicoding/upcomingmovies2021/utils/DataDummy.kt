package com.dicoding.upcomingmovies2021.utils

import com.dicoding.upcomingmovies2021.data.source.local.entities.CompanyEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.GenreEmbedded
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.relations.GenreWithMovies
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowGenreEntity
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.relations.GenreWithTvShows
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.*
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.ProductionCompany
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.*
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.Genre

object DummyData {

    fun generateMovieEntities(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                backdropPath = "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
                movieId = 423108,
                originalTitle = "The Conjuring: The Devil Made Me Do It",
                posterPath = "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                releaseDate = "2021-05-25",
                title = "The Conjuring: The Devil Made Me Do It",
            ),
            MovieEntity(
                backdropPath = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                movieId = 460465,
                originalTitle = "Mortal Kombat",
                posterPath = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                releaseDate = "2021-04-07",
                title = "Mortal Kombat",
            )
        )
    }

    fun generateTvShowEntities(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                backdropPath = "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
                firstAirDate = "2021-06-09",
                tvShowId = 84958,
                name = "Loki",
                originalName = "Loki",
                posterPath = "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
            ),
            TvShowEntity(
                backdropPath = "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                firstAirDate = "2014-10-07",
                tvShowId = 60735,
                name = "The Flash",
                originalName = "The Flash",
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            )
        )
    }

    fun generateDetailMovieEntities(): List<DetailMovieEntity> {
        return listOf(
            DetailMovieEntity(
                backdropPath = "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
                genre = listOf(
                    GenreEmbedded(
                        genreId = 27,
                        genreName = "Horror"
                    ),
                    GenreEmbedded(
                        genreId = 9648,
                        genreName = "Mystery"
                    ),
                    GenreEmbedded(
                        genreId = 53,
                        genreName = "Thriller"
                    )
                ),
                detailMovieId = 423108,
                originalTitle = "The Conjuring: The Devil Made Me Do It",
                overview = "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                posterPath = "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                companies = listOf(
                    CompanyEmbedded(
                        movieCompanyId = 12,
                        companyName = "New Line Cinema",
                    ),
                    CompanyEmbedded(
                        movieCompanyId = 11565,
                        companyName = "The Safran Company",
                    ),
                    CompanyEmbedded(
                        movieCompanyId = 76907,
                        companyName = "Atomic Monster",
                    ),
                    CompanyEmbedded(
                        movieCompanyId = 174,
                        companyName = "Warner Bros. Pictures",
                    )
                ),
                releaseDate = "2021-05-25",
                status = "Released",
                title = "The Conjuring: The Devil Made Me Do It",
            ),
        )
    }

    fun generateDetailTvEntities(): List<DetailTvShowEntity> {
        return listOf(
            DetailTvShowEntity(
                backdropPath = "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
                firstAirDate = "2021-06-09",
                genre = listOf(
                    GenreEmbedded(
                        genreId = 18,
                        genreName = "Drama"
                    ),
                    GenreEmbedded(
                        genreId = 10765,
                        genreName = "Sci-Fi & Fantasy"
                    )
                ),
                detailTvShowId = 84958,
                name = "Loki",
                originalName = "Loki",
                overview = "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                posterPath = "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                companies = listOf(
                    CompanyEmbedded(
                        movieCompanyId = 420,
                        companyName = "Marvel Studios",
                    )
                ),
                status = "Returning Series",
            )
        )
    }

    fun generateMoviesByGenre(): List<GenreWithMovies> {
        return listOf(
            GenreWithMovies(
                MovieGenreEntity(
                    movieGenreId = 27,
                ),
                generateMovieEntities()
            )
        )
    }

    fun generateTvShowsByGenre(): List<GenreWithTvShows> {
        return listOf(
            GenreWithTvShows(
                TvShowGenreEntity(
                    tvShowGenreId = 18,
                ),
                generateTvShowEntities()
            )
        )
    }

    fun generateMovies(): UpcomingMoviesResponse {
        return UpcomingMoviesResponse(
            dates = Dates("19-07-2021", "19-05-2021"),
            page = 1,
            results = listOf(
                MovieResult(
                    adult = false,
                    backdropPath = "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
                    genreIds = listOf(27, 9648, 53),
                    id = 423108,
                    originalLanguage = "en",
                    originalTitle = "The Conjuring: The Devil Made Me Do It",
                    overview = "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                    popularity = 2907.842,
                    posterPath = "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                    releaseDate = "2021-05-25",
                    title = "The Conjuring: The Devil Made Me Do It",
                    video = false,
                    voteAverage = 8.2,
                    voteCount = 2194
                ),
                MovieResult(
                    adult = false,
                    backdropPath = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                    genreIds = listOf(28, 14, 12),
                    id = 460465,
                    originalLanguage = "en",
                    originalTitle = "Mortal Kombat",
                    overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                    popularity = 1373.864,
                    posterPath = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                    releaseDate = "2021-04-07",
                    title = "Mortal Kombat",
                    video = false,
                    voteAverage = 7.5,
                    voteCount = 3018
                )
            ),
            totalPages = 1,
            totalResults = 2
        )
    }

    fun generateTvShows(): TvOnTheAirResponse {
        return TvOnTheAirResponse(
            page = 1,
            totalPages = 1,
            totalResults = 2,
            results = listOf(
                TvShowResult(
                    backdropPath = "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
                    firstAirDate = "2021-06-09",
                    genreIds = listOf(18, 10765),
                    id = 84958,
                    name = "Loki",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "Loki",
                    overview = "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                    popularity = 7218.609,
                    posterPath = "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                    voteAverage = 8.1,
                    voteCount = 3018
                ),
                TvShowResult(
                    backdropPath = "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                    firstAirDate = "2014-10-07",
                    genreIds = listOf(18, 10765),
                    id = 60735,
                    name = "The Flash",
                    originCountry = listOf("US"),
                    originalLanguage = "en",
                    originalName = "The Flash",
                    overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    popularity = 1240.98,
                    posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    voteAverage = 7.7,
                    voteCount = 7835
                )
            )
        )
    }

    fun generateDetailMovie(): DetailMovieResponse {
        return DetailMovieResponse(
            adult = false,
            backdropPath = "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
            budget = 39000000,
            genres = listOf(
                com.dicoding.upcomingmovies2021.data.source.remote.models.movie.Genre(
                    id = 27,
                    name = "Horror"
                ),
                com.dicoding.upcomingmovies2021.data.source.remote.models.movie.Genre(
                    id = 9648,
                    name = "Mystery"
                ),
                com.dicoding.upcomingmovies2021.data.source.remote.models.movie.Genre(
                    id = 53,
                    name = "Thriller"
                )
            ),
            homepage = "http://www.theconjuringmovie.net",
            id = 423108,
            imdbId = "tt7069210",
            originalLanguage = "en",
            originalTitle = "The Conjuring: The Devil Made Me Do It",
            overview = "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
            popularity = 2907.842,
            posterPath = "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
            productionCompanies = listOf(
                ProductionCompany(
                    id = 12,
                    logoPath = "/iaYpEp3LQmb8AfAtmTvpqd4149c.png",
                    name = "New Line Cinema",
                    originCountry = "US"
                ),
                ProductionCompany(
                    id = 11565,
                    logoPath = null,
                    name = "The Safran Company",
                    originCountry = "US"
                ),
                ProductionCompany(
                    id = 76907,
                    logoPath = "/wChlWsVgwSd4ZWxTIm8PTEcaESz.png",
                    name = "Atomic Monster",
                    originCountry = "US"
                ),
                ProductionCompany(
                    id = 174,
                    logoPath = "/IuAlhI9eVC9Z8UQWOIDdWRKSEJ.png",
                    name = "Warner Bros. Pictures",
                    originCountry = "US"
                )
            ),
            releaseDate = "2021-05-25",
            revenue = 111800000,
            runtime = 111,
            status = "Released",
            tagline = "The demonic case that shocked America.",
            title = "The Conjuring: The Devil Made Me Do It",
            video = false,
            voteAverage = 8.2,
            voteCount = 2209
        )
    }

    fun generateDetailTvShow(): DetailTvShowResponse {
        return DetailTvShowResponse(
            backdropPath = "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
            createdBy = listOf(
                CreatedBy(
                    id = 2094567,
                    creditId = "6001713e7390c0003df730af",
                    name = "Michael Waldron",
                    gender = 2,
                    profilePath = "/5d6wkYnJgkVAzThqnnwOLNDzACM.jpg"
                )
            ),
            episodeRunTime = listOf(52),
            firstAirDate = "2021-06-09",
            genres = listOf(
                Genre(
                    id = 18,
                    name = "Drama"
                ),
                Genre(
                    id = 10765,
                    name = "Sci-Fi & Fantasy"
                )
            ),
            homepage = "https://www.disneyplus.com/series/wp/6pARMvILBGzF",
            id = 84958,
            inProduction = true,
            languages = listOf(
                "en"
            ),
            lastAirDate = "2021-06-16",
            lastEpisodeToAir = LastEpisodeToAir(
                airDate = "2021-06-16",
                episodeNumber = 2,
                id = 2927202,
                name = "The Variant",
                overview = "Mobius puts Loki to work, but not everyone at TVA is thrilled about the God of Mischief's presence.",
                productionCode = "",
                seasonNumber = 1,
                stillPath = "/gqpcfkdmSsm6xiX2EsLkwUvA8g8.jpg",
                voteAverage = 7.0,
                voteCount = 5
            ),
            name = "Loki",
            networks = listOf(
                Network(
                    name = "Disney+",
                    id = 2739,
                    logoPath = "/gJ8VX6JSu3ciXHuC2dDGAo2lvwM.png",
                    originCountry = "US"
                )
            ),
            numberOfEpisodes = 6,
            numberOfSeasons = 1,
            originCountry = listOf("US"),
            originalLanguage = "en",
            originalName = "Loki",
            overview = "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
            popularity = 7218.609,
            posterPath = "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
            productionCompanies = listOf(
                com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.ProductionCompany(
                    id = 420,
                    logoPath = "/hUzeosd33nzE5MCNsZxCGEKTXaQ.png",
                    name = "Marvel Studios",
                    originCountry = "US"
                )
            ),
            productionCountries = listOf(
                ProductionCountry(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            seasons = listOf(
                Season(
                    airDate = "2021-06-09",
                    episodeCount = 6,
                    id = 114355,
                    name = "Season 1",
                    overview = "",
                    posterPath = "/8uVqe9ThcuYVNdh4O0kuijIWMLL.jpg",
                    seasonNumber = 1
                )
            ),
            status = "Returning Series",
            tagline = "Loki's time has come.",
            type = "Miniseries",
            voteAverage = 8.1,
            voteCount = 3102
        )
    }
}