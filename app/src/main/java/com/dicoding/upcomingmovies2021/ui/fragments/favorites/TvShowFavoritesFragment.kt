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
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.databinding.FragmentTvShowFavoritesBinding
import com.dicoding.upcomingmovies2021.ui.adapter.favorites.RvTvShowFavoritesAdapter
import com.dicoding.upcomingmovies2021.ui.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFavoritesFragment : Fragment(R.layout.fragment_tv_show_favorites) {

    private lateinit var binding: FragmentTvShowFavoritesBinding
    private val viewModel: TvShowViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTvShowFavoritesBinding.bind(view)
        setHasOptionsMenu(true)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.getFavTvShows().observe(viewLifecycleOwner, { data ->
            setupRv(data)
        })
    }

    private fun setupRv(data: PagedList<DetailTvShowEntity>) {
        val tvShowAdapter = RvTvShowFavoritesAdapter()
        tvShowAdapter.submitList(data)
        with(binding.rvTvShowFavorites) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fav_tv_show, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                activity?.finish()
                true
            }
            R.id.menu_delete_tv_show -> {
                viewModel.deleteAllFavorites()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}