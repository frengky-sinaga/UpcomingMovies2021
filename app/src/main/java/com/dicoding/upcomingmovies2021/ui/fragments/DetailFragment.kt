package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.databinding.FragmentDetailBinding
import com.dicoding.upcomingmovies2021.ui.viewmodel.DetailViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding
    private lateinit var result: DetailFilmEntity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        val extraId = args.extraId
        val extraTypeFilm = args.extraTypeFilm

        Log.d("idFilm", "$extraId with $extraTypeFilm")

        /*viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailViewModel::class.java)

        arguments?.get(EXTRA_TYPE).also {
            val id = arguments?.get(EXTRA_DATA)
            result =
                if (it == TypeFilm.Movie) viewModel.getDetailMovieById(id.toString()) else viewModel.getDetailTvShowById(
                    id.toString()
                )
        }*/
        //populateData()
    }

    private fun populateData() {
        binding.tvTitle.text = result.title
        binding.tvReleaseDate.text = result.releaseDate
        binding.contentDescription.text = result.description
        binding.imgPoster.load(result.poster) {
            scale(Scale.FIT)
            placeholder(R.drawable.ic_placeholder)
            crossfade(true)
            crossfade(400)
            transformations(GrayscaleTransformation())
        }
        binding.imgIcon.load(result.poster) {
            placeholder(R.drawable.ic_placeholder)
            transformations(CircleCropTransformation())
        }
        for (genre in result.genre) {
            createChip(genre.toString())
        }
    }

    private fun createChip(txt: String) {
        val chip = Chip(context)
        chip.apply {
            text = txt
            isChipIconVisible = false
            isCloseIconVisible = false
            isClickable = false
            isCheckable = false
            binding.chipGenre.addView(chip)
        }
    }
}


