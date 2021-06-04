package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentDetailBinding
import com.dicoding.upcomingmovies2021.ui.viewmodel.FilmViewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: FilmViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity()).get(FilmViewModel::class.java)

        viewModel.getDataFilm().observe(viewLifecycleOwner, { data ->
            binding.tvTitle.text = data.title
            binding.tvDescription.text = data.description
            binding.imgPoster.load(data.poster)
        })
    }
}