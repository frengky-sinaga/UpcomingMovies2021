package com.dicoding.upcomingmovies2021.utils

import com.dicoding.upcomingmovies2021.data.CrewFilmEntity
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity

object DataDummy {

    fun generateDummyMovie(): List<DetailFilmEntity> {

        val detailFilm = ArrayList<DetailFilmEntity>()

        detailFilm.add(
            DetailFilmEntity(
                title = "Snake Eyes: G.I. Joe Origins",
                poster = "https://upload.wikimedia.org/wikipedia/en/3/38/Snake_Eyes_-_G.I._Joe_Origins%2C_official_poster.png",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Fantasy,
                ),
                releaseDate = "July 23, 2021",
                crews = CrewFilmEntity(
                    director = "Robert Schwentke",
                    writers = listOf("Evan Spiliotopoulos"),
                    stars = listOf("Henry Golding", "Andrew Koji", "Samara Weaving"),
                ),
                description = "A G.I. Joe spin-off centered around the character of Snake Eyes.",
                link = "https://www.imdb.com/title/tt8404256/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                title = "No Time to Die",
                poster = "https://upload.wikimedia.org/wikipedia/en/f/fe/No_Time_to_Die_poster.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Thriller,
                ),
                releaseDate = "October 8, 2021",
                crews = CrewFilmEntity(
                    director = "Cary Joji Fukunaga",
                    writers = listOf("Neal Purvis", "Robert Wade", "Cary Joji Fukunaga"),
                    stars = listOf("Daniel Craig", "Ana de Armas", "Rami Malek"),
                ),
                description = "James Bond has left active service. His peace is short-lived when Felix Leiter, " +
                        "an old friend from the CIA, turns up asking for help, leading Bond onto the trail of " +
                        "a mysterious villain armed with dangerous new technology.",
                link = "https://www.imdb.com/title/tt2382320/",
                typeFilm = TypeFilm.Movie,
            )
        )

        return detailFilm
    }

    fun generateDummyTvShow(): List<DetailFilmEntity> {

        val detailFilm = ArrayList<DetailFilmEntity>()

        detailFilm.add(
            DetailFilmEntity(
                title = "Loki",
                poster = "https://upload.wikimedia.org/wikipedia/en/4/4e/Loki_%28TV_series%29_logo.png",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Fantasy,
                ),
                releaseDate = "June 9, 2021",
                crews = CrewFilmEntity(
                    director = null,
                    writers = null,
                    stars = listOf("Tom Hiddleston", "Owen Wilson", "Sophia Di Martino")
                ),
                description = "A new Marvel chapter with Loki at its center.",
                link = "https://www.imdb.com/title/tt9140554/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        return detailFilm
    }
}