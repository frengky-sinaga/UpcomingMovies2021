package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.MovieResult
import com.dicoding.upcomingmovies2021.databinding.FragmentMovieBinding
import com.dicoding.upcomingmovies2021.ui.interfaces.OnMovieItemClickCallback
import com.dicoding.upcomingmovies2021.ui.adapter.RvMovieAdapter
import com.dicoding.upcomingmovies2021.ui.viewmodel.FilmViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment(R.layout.fragment_movie), OnMovieItemClickCallback {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel: FilmViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        setAdapter()
    }

    private fun setAdapter() {
        viewModel.movieResponse.observe(viewLifecycleOwner, { data ->
            val movieAdapter = RvMovieAdapter(this)
            movieAdapter.setDetail(data)
            with(binding.rvFilm) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        })
    }

    override fun onItemClicked(data: MovieResult) {
        /*val bundle = Bundle()
        bundle.putString(DetailFragment.EXTRA_DATA, data.idFilm)
        bundle.putSerializable(DetailFragment.EXTRA_TYPE, data.typeFilm)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        val fm = activity?.supportFragmentManager
        fm?.beginTransaction()?.apply {
            replace(
                R.id.main_container,
                detailFragment,
                DetailFragment::class.java.simpleName
            )
            addToBackStack(null)
            commit()
        }*/
    }
}