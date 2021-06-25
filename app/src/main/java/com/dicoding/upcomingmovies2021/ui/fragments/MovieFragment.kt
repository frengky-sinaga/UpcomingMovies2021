package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.databinding.FragmentMovieBinding
import com.dicoding.upcomingmovies2021.ui.adapter.RvMovieAdapter
import com.dicoding.upcomingmovies2021.ui.viewmodel.MovieViewModel
import com.dicoding.upcomingmovies2021.vo.Resource
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
        viewModel.getMovies().observe(viewLifecycleOwner, { resources ->
            when (resources.status) {
                Resource.Status.SUCCESS -> {
                    dismissLoading()
                    resources.data?.let {
                        setupRv(it)
                    }
                }
                Resource.Status.ERROR -> {
                    dismissLoading()
                    resources.message?.let {
                        showToast(it)
                    }
                }
                Resource.Status.LOADING -> showLoading()
                Resource.Status.EMPTY -> dismissLoading()
            }
        })
    }

    private fun setupRv(data: List<MovieEntity>) {
        val movieAdapter = RvMovieAdapter()
        movieAdapter.setMovies(data)
        with(binding.rvFilm) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    private fun showLoading() {
        binding.apply {
            progressMovie.visibility = View.VISIBLE
        }
    }

    private fun dismissLoading() {
        binding.apply {
            progressMovie.visibility = View.GONE
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}