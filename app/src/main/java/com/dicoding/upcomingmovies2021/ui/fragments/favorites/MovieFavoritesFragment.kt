package com.dicoding.upcomingmovies2021.ui.fragments.favorites

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.databinding.FragmentMovieFavoritesBinding
import com.dicoding.upcomingmovies2021.ui.adapter.favorites.RvMovieFavoritesAdapter
import com.dicoding.upcomingmovies2021.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFavoritesFragment : Fragment(R.layout.fragment_movie_favorites) {

    private lateinit var binding: FragmentMovieFavoritesBinding
    private val viewModel: MovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieFavoritesBinding.bind(view)
        setHasOptionsMenu(true)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getFavMovies().observe(viewLifecycleOwner, { data ->
            setupRv(data)
        })
    }

    private fun setupRv(data: PagedList<DetailMovieEntity>) {
        val movieAdapter = RvMovieFavoritesAdapter()
        movieAdapter.submitList(data)
        with(binding.rvMovieFavorites) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fav_movie, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                activity?.finish()
                true
            }
            R.id.menu_delete_movie -> {
                viewModel.deleteAllFavorites()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}