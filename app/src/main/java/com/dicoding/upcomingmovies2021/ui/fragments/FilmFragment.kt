package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentFilmBinding
import com.dicoding.upcomingmovies2021.ui.adapter.RvAdapter
import com.dicoding.upcomingmovies2021.utils.DataDummy

class FilmFragment : Fragment(R.layout.fragment_film) {
    private lateinit var binding: FragmentFilmBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilmBinding.bind(view)

        setAdapter()
    }

    private fun setAdapter() {
        val movieList = DataDummy.generateDummyMovie()
        val movieAdapter = RvAdapter()
        movieAdapter.setDetail(movieList)

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

}