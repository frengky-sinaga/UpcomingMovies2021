package com.dicoding.upcomingmovies2021.utils

import com.dicoding.upcomingmovies2021.data.CrewFilmEntity
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity

object DataDummy {

    fun generateDummyMovie(): List<DetailFilmEntity> {

        val detailFilm = ArrayList<DetailFilmEntity>()

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt8404256",
                title = "Snake Eyes: G.I. Joe Origins",
                poster = "https://upload.wikimedia.org/wikipedia/en/3/38/Snake_Eyes_-_G.I._Joe_Origins%2C_official_poster.png",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Fantasy,
                ),
                releaseDate = "July 23, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Robert Schwentke"),
                    writers = listOf("Evan Spiliotopoulos"),
                    stars = listOf("Henry Golding", "Andrew Koji", "Samara Weaving"),
                    creators = null
                ),
                description = "A G.I. Joe spin-off centered around the character of Snake Eyes.",
                link = "https://www.imdb.com/title/tt8404256/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt2382320",
                title = "No Time to Die",
                poster = "https://upload.wikimedia.org/wikipedia/en/f/fe/No_Time_to_Die_poster.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Thriller,
                ),
                releaseDate = "October 8, 2021 (expected)",
                crews = CrewFilmEntity(
                    directors = listOf("Cary Joji Fukunaga"),
                    writers = listOf("Neal Purvis", "Robert Wade", "Cary Joji Fukunaga"),
                    stars = listOf("Daniel Craig", "Ana de Armas", "Rami Malek"),
                    creators = null
                ),
                description = "James Bond has left active service. His peace is short-lived when Felix Leiter, " +
                        "an old friend from the CIA, turns up asking for help, leading Bond onto the trail of " +
                        "a mysterious villain armed with dangerous new technology.",
                link = "https://www.imdb.com/title/tt2382320/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt8385148",
                title = "The Hitman's Wife's Bodyguard",
                poster = "https://upload.wikimedia.org/wikipedia/en/a/ab/Hitman%27s_Wife%27s_Bodyguard_%282021_film%29_theatrical_release_poster.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.Comedy,
                    Genre.Crime,
                ),
                releaseDate = "June 16, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Patrick Hughes"),
                    writers = listOf("Tom O\'Connor", "Brandon Murphy", "Phillip Murphy"),
                    stars = listOf("Ryan Reynolds", "Salma Hayek", "Frank Grillo"),
                    creators = null
                ),
                description = "The bodyguard Michael Bryce continues his friendship with " +
                        "assassin Darius Kincaid as they try to save Darius's wife Sonia.",
                link = "https://www.imdb.com/title/tt8385148/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt6334354",
                title = "The Suicide Squad",
                poster = "https://upload.wikimedia.org/wikipedia/en/4/4e/The_Suicide_Squad_official_poster.jpeg",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Comedy,
                ),
                releaseDate = "August 6, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("James Gunn"),
                    writers = listOf("James Gunn", "John Ostrander"),
                    stars = listOf("Margot Robbie", "Idris Elba", "John Cena"),
                    creators = null
                ),
                description = "Supervillains Harley Quinn, Bloodsport, Peacemaker and " +
                        "a collection of nutty cons at Belle Reve prison join the super-secret, " +
                        "super-shady Task Force X as they are dropped off at the remote, " +
                        "enemy-infused island of Corto Maltese.",
                link = "https://www.imdb.com/title/tt6334354/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt1745960",
                title = "Top Gun: Maverick",
                poster = "https://upload.wikimedia.org/wikipedia/en/d/d2/Top_Gun_Maverick.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.Drama,
                ),
                releaseDate = "November 19, 2021 (expected)",
                crews = CrewFilmEntity(
                    directors = listOf("Joseph Kosinski"),
                    writers = listOf("Ehren Kruger", "Eric Warren Singer", "Christopher McQuarrie"),
                    stars = listOf("Tom Cruise", "Jennifer Connelly", "Miles Teller"),
                    creators = null
                ),
                description = "After more than thirty years of service as one of the Navy's top aviators, " +
                        "Pete Mitchell is where he belongs, pushing the envelope as a courageous test pilot " +
                        "and dodging the advancement in rank that would ground him.",
                link = "https://www.imdb.com/title/tt1745960/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt3480822",
                title = "Black Widow",
                poster = "https://upload.wikimedia.org/wikipedia/en/7/74/Black_Widow_poster.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.SciFi
                ),
                releaseDate = "July 9, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Cate Shortland"),
                    writers = listOf("Jac Schaeffer", "Ned Benson", "Eric Pearson"),
                    stars = listOf("Scarlett Johansson", "Florence Pugh", "David Harbour"),
                    creators = null
                ),
                description = "A film about Natasha Romanoff in her quests between the films Civil War and Infinity War.",
                link = "https://www.imdb.com/title/tt3480822/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt7097896",
                title = "Venom: Let There Be Carnage",
                poster = "https://upload.wikimedia.org/wikipedia/en/a/a7/Venom_Let_There_Be_Carnage_poster.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.SciFi,
                    Genre.Thriller
                ),
                releaseDate = "September 24, 2021 (expected)",
                crews = CrewFilmEntity(
                    directors = listOf("Andy Serkis"),
                    writers = listOf("JKelly Marcel", "Tom Hardy"),
                    stars = listOf("Tom Hardy", "Michelle Williams", "Woody Harrelson"),
                    creators = null
                ),
                description = "Plot unknown. Sequel to the 2018 film \'Venom\'.",
                link = "https://www.imdb.com/title/tt7097896/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt10327252",
                title = "The Forever Purge",
                poster = "https://upload.wikimedia.org/wikipedia/en/e/e2/Forever_Purge_poster.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.Horror,
                    Genre.SciFi
                ),
                releaseDate = "July 2, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Everardo Gout"),
                    writers = listOf("James DeMonaco"),
                    stars = listOf("Ana de la Reguera", "Josh Lucas", "Will Patton"),
                    creators = null
                ),
                description = "All the rules are broken as a sect of lawless marauders decides " +
                        "that the annual Purge does not stop at daybreak and instead should never end.",
                link = "https://www.imdb.com/title/tt10327252/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt9243804",
                title = "The Green Knight",
                poster = "https://upload.wikimedia.org/wikipedia/en/0/09/The_Green_Knight_poster.jpeg",
                genre = listOf(
                    Genre.Adventure,
                    Genre.Drama,
                    Genre.Fantasy
                ),
                releaseDate = "July 30, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("David Lowery"),
                    writers = listOf("David Lowery"),
                    stars = listOf("Dev Patel", "Alicia Vikander", "Joel Edgerton"),
                    creators = null
                ),
                description = "A fantasy re-telling of the medieval story of Sir Gawain and the Green Knight.",
                link = "https://www.imdb.com/title/tt9243804/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt9848626",
                title = "Hotel Transylvania: Transformania",
                poster = "https://upload.wikimedia.org/wikipedia/en/c/cf/Hotel_Transylvania_Transformania_poster.jpg",
                genre = listOf(
                    Genre.Animation,
                    Genre.Adventure,
                    Genre.Comedy
                ),
                releaseDate = "July 23, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Derek Drymon", "Jennifer Kluska"),
                    writers = listOf("Genndy Tartakovsky"),
                    stars = listOf("Brian Hull", "Andy Samberg", "Selena Gomez"),
                    creators = null
                ),
                description = "Drac's Pack is back, like you've never seen them before in the final chapter of \'Hotel Transylvania\'.",
                link = "https://www.imdb.com/title/tt9848626/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt4733624",
                title = "Fatherhood",
                poster = "https://upload.wikimedia.org/wikipedia/en/f/f5/Fatherhood_poster.jpg",
                genre = listOf(
                    Genre.Comedy,
                    Genre.Drama
                ),
                releaseDate = "June 18, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Paul Weitz"),
                    writers = listOf("Dana Stevens", "Paul Weitz", "Matt Logelin"),
                    stars = listOf("Paul Alexander Désiré", "Rodney Alexandre", "Christine Lan"),
                    creators = null
                ),
                description = "A father brings up his baby girl as a single dad after the unexpected death of his wife " +
                        "who died a day after their daughter's birth.",
                link = "https://www.imdb.com/title/tt4733624/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt9357050",
                title = "Dear Evan Hansen",
                poster = "https://upload.wikimedia.org/wikipedia/en/9/91/DearEvanposter.png",
                genre = listOf(
                    Genre.Drama,
                    Genre.Musical
                ),
                releaseDate = "September 24, 2021 (expected)",
                crews = CrewFilmEntity(
                    directors = listOf("Stephen Chbosky"),
                    writers = listOf("Steven Levenson"),
                    stars = listOf("Ben Platt", "Kaitlyn Dever", "Amandla Stenberg"),
                    creators = null
                ),
                description = "Film adaptation of the Tony and Grammy Award-winning musical about Evan Hansen, " +
                        "a high school senior with Social Anxiety disorder and his journey of self-discovery " +
                        "and acceptance following the suicide of a fellow classmate.",
                link = "https://www.imdb.com/title/tt9357050/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt2452150",
                title = "Respect",
                poster = "https://upload.wikimedia.org/wikipedia/en/4/4d/Respect_2020_film_poster.png",
                genre = listOf(
                    Genre.Biography,
                    Genre.Drama,
                    Genre.Music
                ),
                releaseDate = "August 13, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Liesl Tommy"),
                    writers = listOf("Tracey Scott Wilson", "Callie Khouri"),
                    stars = listOf("Jennifer Hudson", "Forest Whitaker", "Audra McDonald"),
                    creators = null
                ),
                description = "The life story of legendary R&B singer, Aretha Franklin.",
                link = "https://www.imdb.com/title/tt2452150/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt5562070",
                title = "Wish Dragon",
                poster = "https://upload.wikimedia.org/wikipedia/en/d/d7/Wish_Dragon.png",
                genre = listOf(
                    Genre.Animation,
                    Genre.Adventure,
                    Genre.Comedy
                ),
                releaseDate = "June 11, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Chris Appelhans"),
                    writers = listOf("Chris Appelhans", "Xiaocao Liu"),
                    stars = listOf("John Cho", "Jimmy Wong", "Natasha Liu Bordizzo"),
                    creators = null
                ),
                description = "Determined teen Din is longing to reconnect with his childhood best friend " +
                        "when he meets a wish-granting dragon who shows him the magic of possibilities.",
                link = "https://www.imdb.com/title/tt5562070/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt9777666",
                title = "The Tomorrow War",
                poster = "https://upload.wikimedia.org/wikipedia/en/6/60/The_Tomorrow_War_%282021_film%29_official_theatrical_poster.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.SciFi
                ),
                releaseDate = "July 2, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Chris McKay"),
                    writers = listOf("Zach Dean"),
                    stars = listOf("Chris Pratt", "Yvonne Strahovski", "J.K. Simmons"),
                    creators = null
                ),
                description = "A family man is drafted to fight in a future war where the fate of humanity relies on his ability to confront the past.",
                link = "https://www.imdb.com/title/tt9777666/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt6264654",
                title = "Free Guy",
                poster = "https://upload.wikimedia.org/wikipedia/en/e/ea/Free_Guy_Theatrical_First_Poster.jpg",
                genre = listOf(
                    Genre.Action,
                    Genre.Comedy,
                    Genre.SciFi
                ),
                releaseDate = "August 13, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Shawn Levy"),
                    writers = listOf("Matt Lieberman", "Zak Penn"),
                    stars = listOf("Ryan Reynolds", "Jodie Comer", "Taika Waititi"),
                    creators = null
                ),
                description = "A bank teller discovers that he's actually an NPC inside a brutal, open world video game.",
                link = "https://www.imdb.com/title/tt6264654/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt9032400",
                title = "Eternals",
                poster = "https://upload.wikimedia.org/wikipedia/en/2/23/Eternals_poster.jpeg",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Drama
                ),
                releaseDate = "November 5, 2021 (expected)",
                crews = CrewFilmEntity(
                    directors = listOf("Chloé Zhao"),
                    writers = listOf("Kaz Firpo", "Chloé Zhao", "Jack Kirby"),
                    stars = listOf("Angelina Jolie", "Gemma Chan", "Richard Madden"),
                    creators = null
                ),
                description = "The saga of the Eternals, a race of immortal beings who lived on Earth and shaped its history and civilizations.",
                link = "https://www.imdb.com/title/tt9032400/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt9844522",
                title = "Escape Room: Tournament of Champions",
                poster = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTBFWOWm47nXfuPBcDcEMmS5QsxwX0DSwgnz4FLNwDD45Omtxaz",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Horror
                ),
                releaseDate = "July 16, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Adam Robitel"),
                    writers = listOf("Fritz Böhm", "Will Honley", "Christine Lavaf"),
                    stars = listOf("Taylor Russell", "Logan Miller", "Thomas Cocquerel"),
                    creators = null
                ),
                description = "Six people unwittingly find themselves locked in another series of escape rooms, " +
                        "slowly uncovering what they have in common to survive. Joining forces with two of the original survivors, " +
                        "they soon discover they've all played the game before.",
                link = "https://www.imdb.com/title/tt9844522/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt4513678",
                title = "Ghostbusters: Afterlife",
                poster = "https://upload.wikimedia.org/wikipedia/en/b/bb/Ghostbusters_Afterlife_-_teaser_poster.jpeg",
                genre = listOf(
                    Genre.Comedy,
                    Genre.Fantasy,
                ),
                releaseDate = "November 11, 2021 (expected)",
                crews = CrewFilmEntity(
                    directors = listOf("Jason Reitman"),
                    writers = listOf("Gil Kenan", "Jason Reitman", "Dan Aykroyd"),
                    stars = listOf("Finn Wolfhard", "Mckenna Grace", "Carrie Coon"),
                    creators = null
                ),
                description = "When a single mom and her two kids arrive in a small town, " +
                        "they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
                link = "https://www.imdb.com/title/tt4513678/",
                typeFilm = TypeFilm.Movie,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt0870154",
                title = "Jungle Cruise",
                poster = "https://upload.wikimedia.org/wikipedia/en/c/c6/Jungle_Cruise_-_theatrical_poster.png",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Comedy,
                ),
                releaseDate = "July 30, 2021",
                crews = CrewFilmEntity(
                    directors = listOf("Jaume Collet-Serra"),
                    writers = listOf("Glenn Ficarra", "John Requa", "Josh Goldstein"),
                    stars = listOf("Dwayne Johnson", "Emily Blunt", "Edgar Ramírez"),
                    creators = null
                ),
                description = "Based on Disneyland's theme park ride where a small riverboat takes a group of travelers " +
                        "through a jungle filled with dangerous animals and reptiles but with a supernatural element.",
                link = "https://www.imdb.com/title/tt0870154/",
                typeFilm = TypeFilm.Movie,
            )
        )

        return detailFilm
    }

    fun generateDummyTvShow(): List<DetailFilmEntity> {

        val detailFilm = ArrayList<DetailFilmEntity>()

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt9140554",
                title = "Loki",
                poster = "https://upload.wikimedia.org/wikipedia/en/4/4e/Loki_%28TV_series%29_logo.png",
                genre = listOf(
                    Genre.Action,
                    Genre.Adventure,
                    Genre.Fantasy,
                ),
                releaseDate = "June 9, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Tom Hiddleston", "Owen Wilson", "Sophia Di Martino"),
                    creators = null
                ),
                description = "A new Marvel chapter with Loki at its center.",
                link = "https://www.imdb.com/title/tt9140554/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt10814438",
                title = "Betty: Season 2",
                poster = "https://upload.wikimedia.org/wikipedia/en/f/f0/Betty_HBO_poster.png",
                genre = listOf(
                    Genre.Comedy,
                ),
                releaseDate = "June 11, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Dede Lovelace", "Kabrina Adams", "Nina Moran"),
                    creators = null
                ),
                description = "A diverse group of young women navigating their lives through the predominantly male oriented world of skateboarding.",
                link = "https://www.imdb.com/title/tt10814438/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt8128344",
                title = "Flack: Season 2",
                poster = "https://m.media-amazon.com/images/M/MV5BZmQ3MTA4NDgtN2QzOS00MWE2LTg1MjktY2U3YmVjMmQ3YmU0XkEyXkFqcGdeQXVyNjcyNjcyMzQ@._V1_.jpg",
                genre = listOf(
                    Genre.Comedy,
                    Genre.Drama
                ),
                releaseDate = "June 11, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Dede Lovelace", "Kabrina Adams", "Nina Moran"),
                    creators = listOf("Oliver Lansley")
                ),
                description = "Robyn, an American publicist working for a cutthroat London PR company " +
                        "that represents troubled celebrities, is adept at keeping her clients\' lives appearing in perfect order, " +
                        "while her own falls to pieces.",
                link = "https://www.imdb.com/title/tt8128344/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt6053512",
                title = "Home Before Dark: Season 2",
                poster = "https://upload.wikimedia.org/wikipedia/en/1/12/Home_Before_Dark_%28TV_series%29_title_card.png",
                genre = listOf(
                    Genre.Crime,
                    Genre.Drama,
                    Genre.Mystery,
                ),
                releaseDate = "June 11, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Louis Herthum", "Jim Sturgess", "Brooklynn Prince"),
                    creators = listOf("Dana Fox", "Dara Resnik")
                ),
                description = "A young girl from the big city uncovers clues to an unsolved cold case while visiting her father's small lakeside town.",
                link = "https://www.imdb.com/title/tt6053512/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt10166602",
                title = "Love, Victor: Season 2",
                poster = "https://upload.wikimedia.org/wikipedia/commons/c/cd/Love%2C_Victor_Title_Logo.jpg",
                genre = listOf(
                    Genre.Comedy,
                    Genre.Drama,
                    Genre.Romance,
                ),
                releaseDate = "June 11, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Michael Cimino", "Bebe Wood", "Mason Gooding"),
                    creators = listOf("Isaac Aptaker", "Elizabeth Berger")
                ),
                description = "Victor is a new student at Creekwood High School on his own journey of self-discovery, " +
                        "facing challenges at home, adjusting to a new city, and struggling with his sexual orientation.",
                link = "https://www.imdb.com/title/tt10166602/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt2531336",
                title = "Lupin: Season 2",
                poster = "https://upload.wikimedia.org/wikipedia/en/f/f1/Lupin_logo.png",
                genre = listOf(
                    Genre.Action,
                    Genre.Crime,
                    Genre.Drama,
                ),
                releaseDate = "June 11, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Omar Sy", "Vincent Londez", "Ludivine Sagnier"),
                    creators = listOf("George Kay")
                ),
                description = "Inspired by the adventures of Arsène Lupin, " +
                        "gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                link = "https://www.imdb.com/title/tt2531336/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt11097374",
                title = "Blindspotting",
                poster = "https://pbs.twimg.com/media/Ewti_V4UUAQwHSB.jpg?format=jpg&name=small",
                genre = listOf(
                    Genre.Comedy,
                    Genre.Crime,
                    Genre.Drama,
                ),
                releaseDate = "June 13, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Helen Hunt", "Jasmine Cephas Jones", "Atticus Woodward"),
                    creators = null
                ),
                description = "As Ashley's partner of 12 years and father of their son, Miles is suddenly incarcerated, " +
                        "leaving her to navigate a chaotic and humorous existential crisis when she's forced to move in with Miles' mother " +
                        "and half-sister.",
                link = "https://www.imdb.com/title/tt11097374/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt8036272",
                title = "Tuca & Bertie: Season 2",
                poster = "https://upload.wikimedia.org/wikipedia/en/5/57/Tuca_%26_Bertie_Title_Card.jpg",
                genre = listOf(
                    Genre.Animation,
                    Genre.Comedy,
                ),
                releaseDate = "June 13, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Tiffany Haddish", "Ali Wong", "Steven Yeun"),
                    creators = listOf("Lisa Hanawalt")
                ),
                description = "The story of two 30-year old bird women who live in the same apartment building.",
                link = "https://www.imdb.com/title/tt8036272/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt11815244",
                title = "The Republic of Sarah",
                poster = "https://upload.wikimedia.org/wikipedia/en/c/c8/The_Republic_of_Sarah_Season_One_Poster.jpeg",
                genre = listOf(
                    Genre.Drama,
                ),
                releaseDate = "June 14, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Stella Baker", "Luke Mitchell", "Hope Lauren"),
                    creators = null
                ),
                description = "Faced with the destruction of her town at the hands of a greedy mining company, " +
                        "rebellious high school teacher Sarah Cooper utilizes an obscure cartographical loophole to declare independence.",
                link = "https://www.imdb.com/title/tt11815244/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        detailFilm.add(
            DetailFilmEntity(
                idFilm = "tt7134908",
                title = "Elite: Season 4",
                poster = "https://geotimes.id/wp-content/uploads/2017/08/ELITE1.jpg",
                genre = listOf(
                    Genre.Crime,
                    Genre.Drama,
                    Genre.Thriller
                ),
                releaseDate = "June 18, 2021",
                crews = CrewFilmEntity(
                    directors = null,
                    writers = null,
                    stars = listOf("Itzan Escamilla", "Omar Ayuso", "Miguel Bernardeau"),
                    creators = listOf("Darío Madrona", "Carlos Montero")
                ),
                description = "When three working-class teenagers begin attending an exclusive private school in Spain, " +
                        "the clash between them and the wealthy students leads to murder.",
                link = "https://www.imdb.com/title/tt7134908/",
                typeFilm = TypeFilm.TvShow,
            )
        )

        return detailFilm
    }
}