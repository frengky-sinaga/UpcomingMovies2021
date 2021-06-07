package com.dicoding.upcomingmovies2021.ui.fragments

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.ui.MainActivity
import com.dicoding.upcomingmovies2021.utils.DataDummy
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        onView(allOf(withId(R.id.rv_film), isDisplayed()))
            .perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    dummyMovie.size
                )
            )
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(allOf(withId(R.id.rv_film), isDisplayed()))
            .perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                    dummyTvShow.size
                )
            )
    }

    @Test
    fun viewDetail() {
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(allOf(withId(R.id.rv_film), isDisplayed()))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.img_icon)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.content_description)).check(matches(withText(dummyTvShow[0].description)))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyTvShow[0].releaseDate)))
        onView(withId(R.id.chip_stars)).check(matches(isDisplayed()))

        val director = dummyTvShow[0].crews.directors.isNullOrEmpty()
        if (!director) {
            onView(withId(R.id.chip_directors)).check(matches(isDisplayed()))
        }
        val writer = dummyTvShow[0].crews.writers.isNullOrEmpty()
        if (!writer) {
            onView(withId(R.id.chip_writers)).check(matches(isDisplayed()))
        }
        val creator = dummyTvShow[0].crews.creators.isNullOrEmpty()
        if (!creator) {
            onView(withId(R.id.chip_creators)).check(matches(isDisplayed()))
        }
    }
}