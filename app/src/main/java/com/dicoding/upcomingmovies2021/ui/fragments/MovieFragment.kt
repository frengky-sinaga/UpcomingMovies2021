package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.MovieResult
import com.dicoding.upcomingmovies2021.databinding.FragmentMovieBinding
import com.dicoding.upcomingmovies2021.ui.adapter.RvMovieAdapter
import com.dicoding.upcomingmovies2021.ui.viewmodel.MovieViewModel
import com.dicoding.upcomingmovies2021.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie) {

    private val viewModel: MovieViewModel by viewModels()
    private lateinit var binding: FragmentMovieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMovieBinding.bind(view)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.movieResult.observe(viewLifecycleOwner, { resources ->
            when (resources.status) {
                Resource.Status.SUCCESS -> {
                    resources.data?.let {
                        val dataMovies = it.results.toMutableList()
                        setupRv(dataMovies)
                    }
                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.LOADING -> {

                }
            }
        })
    }

    private fun setupRv(data: List<MovieResult>) {
        val movieAdapter = RvMovieAdapter()
        movieAdapter.setDetail(data)
        with(binding.rvFilm) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}