package com.dicoding.upcomingmovies2021.ui.fragments

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
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
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.ui.MainActivity
import com.dicoding.upcomingmovies2021.utils.DataDummy
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
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

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))

        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.img_icon)).check(matches(isDisplayed()))

        onView(withId(R.id.content_description)).check(matches(isDisplayed()))
        onView(withId(R.id.content_description)).check(matches(withText(dummyMovie[0].description)))

        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyMovie[0].releaseDate)))

        onView(withId(R.id.chip_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_directors)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_writers)).check(matches(isDisplayed()))
    }

    @Test
    fun viewDetailTvShow() {
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.fragment_detail)).perform(swipeUp())

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))

        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.img_icon)).check(matches(isDisplayed()))

        onView(withId(R.id.content_description)).check(matches(isDisplayed()))
        onView(withId(R.id.content_description)).check(matches(withText(dummyTvShow[0].description)))

        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyTvShow[0].releaseDate)))

        onView(withId(R.id.chip_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.chip_stars)).check(matches(isDisplayed()))
        val creatorStatus = dummyTvShow[0].crews.creators.isNullOrEmpty()
        if (!creatorStatus) onView(withId(R.id.chip_creators)).check(matches(isDisplayed()))
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