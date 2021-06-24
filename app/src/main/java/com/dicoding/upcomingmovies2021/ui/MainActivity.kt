package com.dicoding.upcomingmovies2021.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.ActivityMainBinding
import com.dicoding.upcomingmovies2021.ui.fragments.DrawerFragment
import com.google.android.material.bottomappbar.BottomAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener,
    Toolbar.OnMenuItemClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_UpcomingMovies2021)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setController()
        setBottomAppBar()
    }

    private fun setController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val controller = navHostFragment.navController
        controller.addOnDestinationChangedListener(this)
    }

    private fun setBottomAppBar() {
        binding.bottomAppBar.apply {
            setOnMenuItemClickListener(this@MainActivity)
            setNavigationOnClickListener {
                val drawerFragment = DrawerFragment()
                drawerFragment.show(supportFragmentManager, drawerFragment.tag)
            }
        }
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.homeFragment -> destinationHome()
            R.id.favoritesFragment -> destinationHome()
            R.id.detailFragment -> destinationDetail()
        }
    }

    private fun destinationDetail() {
        binding.apply {
            bottomAppBar.apply {
                fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                performHide()
                visibility = View.GONE
            }
            fab.setImageDrawable(
                AppCompatResources.getDrawable(
                    this@MainActivity,
                    R.drawable.ic_favorite_border
                )
            )
        }
    }

    private fun destinationHome() {
        binding.apply {
            bottomAppBar.apply {
                fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                visibility = View.VISIBLE
                performShow()
            }
            fab.setImageDrawable(
                AppCompatResources.getDrawable(
                    this@MainActivity,
                    R.drawable.ic_movie_filter
                )
            )
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_exit -> finish()
        }
        return true
    }
}