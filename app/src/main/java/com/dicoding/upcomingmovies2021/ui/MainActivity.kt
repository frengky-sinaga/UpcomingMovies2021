package com.dicoding.upcomingmovies2021.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.ActivityMainBinding
import com.dicoding.upcomingmovies2021.ui.fragments.DrawerFragment
import com.google.android.material.bottomappbar.BottomAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener{

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
            when(destination.id){
                R.id.homeFragment ->{
                    bottomAppBar.apply {
                        replaceMenu(R.menu.menu_appbar)
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
                R.id.favoritesFragment -> {
                    bottomAppBar.apply {
                        replaceMenu(R.menu.menu_appbar_favorite)
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
                R.id.detailFragment -> {
                    bottomAppBar.apply {
                        fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                        performHide()
                        visibility = View.GONE
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_appbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}