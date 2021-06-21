package com.dicoding.upcomingmovies2021.ui.fragments

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.ui.MainActivity
import com.dicoding.upcomingmovies2021.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                10
            )
        )
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                0
            )
        )
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                10
            )
        )
    }

    @Test
    fun viewDetailMovie() {
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.fragment_detail)).perform(swipeUp())
        onView(withId(R.id.tv_title_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.toolbar_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_genre_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_production_company_detailFilm)).check(matches(isDisplayed()))
    }

    @Test
    fun viewDetailTvShow() {
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.fragment_detail)).perform(swipeUp())
        onView(withId(R.id.tv_title_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.img_poster_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.toolbar_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_genre_detailFilm)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_production_company_detailFilm)).check(matches(isDisplayed()))
    }

    private fun swipeLeft(): ViewAction {
        return GeneralSwipeAction(
            Swipe.FAST, GeneralLocation.CENTER_RIGHT,
            GeneralLocation.CENTER_LEFT, Press.FINGER
        )
    }

    private fun swipeUp(): ViewAction {
        return GeneralSwipeAction(
            Swipe.FAST, GeneralLocation.BOTTOM_CENTER,
            GeneralLocation.TOP_CENTER, Press.FINGER
        )
    }
}