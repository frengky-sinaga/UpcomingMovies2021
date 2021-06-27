package com.dicoding.upcomingmovies2021.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.ActivityMainBinding
import com.dicoding.upcomingmovies2021.ui.fragments.DrawerFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_UpcomingMovies2021)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.bottomAppBar)
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
            navigationContentDescription = "Navigation Drawer"
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
        binding.apply {
            when (destination.id) {
                R.id.homeFragment -> {
                    bottomAppBar.apply {
                        replaceMenu(R.menu.menu_film)
                        visibility = View.VISIBLE
                        performShow()
                    }
                }
                R.id.favoritesFragment -> {
                    bottomAppBar.apply {
                        replaceMenu(R.menu.menu_appbar_favorite)
                        visibility = View.VISIBLE
                        performShow()
                    }
                }
                R.id.detailFragment -> {
                    bottomAppBar.apply {
                        performHide()
                        visibility = View.GONE
                    }
                }
            }
        }
    }
}