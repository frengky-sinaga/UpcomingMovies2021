package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import coil.size.Scale
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentDetailBinding
import com.dicoding.upcomingmovies2021.ui.viewmodel.DetailViewModel
import com.dicoding.upcomingmovies2021.utils.Constants.API_BACKDROP_PATH
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        val extraId = args.extraId
        val extraTypeFilm = args.extraTypeFilm

        Log.d("movieDb", "$extraId with $extraTypeFilm")

        if (extraTypeFilm == TypeFilm.Movie) populateDetailMovie()
        else if (extraTypeFilm == TypeFilm.TvShow) populateTvShow()
    }

    private fun populateDetailMovie() {
        viewModel.movieDetail.observe(viewLifecycleOwner, { detailMovie ->

            binding.apply {
                (requireActivity() as AppCompatActivity).setSupportActionBar(toolbarDetailFilm)
                toolbarDetailFilm.title = detailMovie.title
                toolbarDetailFilm.setNavigationIcon(R.drawable.ic_back)
                toolbarDetailFilm.setNavigationOnClickListener {
                    activity?.onBackPressed()
                }

                tvTitleDetailFilm.text = detailMovie.title
                tvReleaseDateDetailFilm.text = detailMovie.releaseDate
                tvDescriptionDetailFilm.text = detailMovie.overview

                val imgPosterUrl = API_BACKDROP_PATH + detailMovie.backdropPath
                imgPosterDetailFilm.load(imgPosterUrl) {
                    scale(Scale.FILL)
                    placeholder(R.drawable.ic_placeholder)
                    error(R.drawable.ic_broken_image)
                    fallback(R.drawable.ic_placeholder)
                    crossfade(true)
                    crossfade(400)
                }

                for (genre in detailMovie.genres) {
                    createChip(genre.name, 0)
                }

                for (company in detailMovie.productionCompanies) {
                    createChip(company.name, 1)
                }
            }
        })
    }

    private fun populateTvShow() {
        viewModel.tvShowDetail.observe(viewLifecycleOwner, { detailTvShow ->

            binding.apply {
                (requireActivity() as AppCompatActivity).setSupportActionBar(toolbarDetailFilm)
                toolbarDetailFilm.title = detailTvShow.originalName
                toolbarDetailFilm.setNavigationIcon(R.drawable.ic_back)
                toolbarDetailFilm.setNavigationOnClickListener {
                    activity?.onBackPressed()
                }

                tvTitleDetailFilm.text = detailTvShow.originalName
                tvReleaseDateDetailFilm.text = detailTvShow.firstAirDate
                tvDescriptionDetailFilm.text = detailTvShow.overview

                val imgPosterUrl = API_BACKDROP_PATH + detailTvShow.backdropPath
                imgPosterDetailFilm.load(imgPosterUrl) {
                    scale(Scale.FILL)
                    placeholder(R.drawable.ic_placeholder)
                    error(R.drawable.ic_broken_image)
                    fallback(R.drawable.ic_placeholder)
                    crossfade(true)
                    crossfade(400)
                }

                for (genre in detailTvShow.genres) {
                    createChip(genre.name, 0)
                }

                for (company in detailTvShow.productionCompanies) {
                    createChip(company.name, 1)
                }
            }
        })
    }

    private fun createChip(txt: String, type: Int) {
        val chip = Chip(context)
        chip.apply {
            text = txt
            isChipIconVisible = false
            isCloseIconVisible = false
            isClickable = false
            isCheckable = false
            if (type == 0) binding.chipGenreDetailFilm.addView(chip)
            else if (type == 1) binding.chipProductionCompanyDetailFilm.addView(chip)
        }
    }
}