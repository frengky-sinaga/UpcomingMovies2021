package com.dicoding.upcomingmovies2021.ui.fragments

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.ui.MainActivity
import com.dicoding.upcomingmovies2021.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
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
                3
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
                3
            )
        )
    }

    @Test
    fun viewDetailMovie() {
        onView(withId(R.id.rv_film)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_film)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                0
            )
        )
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
        onView(withId(R.id.fab_detail)).perform(click())
    }

    @Test
    fun viewDetailTvShow() {
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                0
            )
        )
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
        onView(withId(R.id.fab_detail)).perform(click())
    }

    @Test
    fun loadFavMovies() {
        onView(withId(R.id.bottomAppBar)).check(matches(isDisplayed()))
        onView(withContentDescription("Navigation Drawer")).perform(click())
        onView(withId(R.id.nav_view_fragment_drawer)).perform(NavigationViewActions.navigateTo(R.id.menu_favorites))
        onView(withId(R.id.rv_movie_favorites)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavTvShows() {
        onView(withId(R.id.bottomAppBar)).check(matches(isDisplayed()))
        onView(withContentDescription("Navigation Drawer")).perform(click())
        onView(withId(R.id.nav_view_fragment_drawer)).perform(NavigationViewActions.navigateTo(R.id.menu_favorites))
        onView(withId(R.id.rv_movie_favorites)).check(matches(isDisplayed()))
        onView(withId(R.id.viewPager_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.viewPager_favorite)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_show_favorites)).check(matches(isDisplayed()))
    }

    @Test
    fun deleteFavorite(){
        onView(withId(R.id.bottomAppBar)).check(matches(isDisplayed()))
        onView(withContentDescription("Navigation Drawer")).perform(click())
        onView(withId(R.id.nav_view_fragment_drawer)).perform(NavigationViewActions.navigateTo(R.id.menu_favorites))
        onView(withId(R.id.rv_movie_favorites)).check(matches(isDisplayed()))
        onView(withId(R.id.menu_delete_movie)).perform(click())
        onView(withId(R.id.viewPager_favorite)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_show_favorites)).check(matches(isDisplayed()))
        onView(withId(R.id.menu_delete_tv_show)).perform(click())
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