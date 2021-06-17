package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.transition.TransitionInflater
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
import com.dicoding.upcomingmovies2021.utils.Resource
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animation =
            TransitionInflater.from(requireContext())
                .inflateTransition(android.R.transition.explode)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        val extraId = args.extraId
        val extraTypeFilm = args.extraTypeFilm

        Log.d("movieDb", "$extraId with $extraTypeFilm")

        if (extraTypeFilm == TypeFilm.Movie) setupDetailMovieObservers()
        else if (extraTypeFilm == TypeFilm.TvShow) setupDetailTvShowObservers()
    }

    private fun setupDetailMovieObservers() {
        viewModel.movieDetail?.observe(viewLifecycleOwner, { resources ->
            when (resources.status) {
                Resource.Status.SUCCESS -> {
                    resources.data?.let { data ->
                        setupToolbar(data.title)
                        data.overview?.let { setupTv(data.originalTitle, data.releaseDate, it) }
                        data.backdropPath?.let { setupImg(it) }
                        for (genre in data.genres) {
                            createChip(genre.name, 0)
                        }

                        for (company in data.productionCompanies) {
                            createChip(company.name, 1)
                        }
                    }
                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.LOADING -> {

                }
            }
        })
    }

    private fun setupDetailTvShowObservers() {
        viewModel.tvShowDetail?.observe(viewLifecycleOwner, { resources ->
            when (resources.status) {
                Resource.Status.SUCCESS -> {
                    resources.data?.let { data ->
                        setupToolbar(data.originalName)
                        setupTv(data.originalName, data.firstAirDate, data.overview)
                        data.backdropPath?.let { setupImg(it) }
                        for (genre in data.genres) {
                            createChip(genre.name, 0)
                        }

                        for (company in data.productionCompanies) {
                            createChip(company.name, 1)
                        }
                    }
                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.LOADING -> {

                }
            }
        })
    }

    private fun setupToolbar(titleToolbar: String) {
        binding.apply {
            (requireActivity() as AppCompatActivity).setSupportActionBar(toolbarDetailFilm)
            toolbarDetailFilm.title = titleToolbar
            toolbarDetailFilm.setNavigationIcon(R.drawable.ic_back)
            toolbarDetailFilm.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun setupImg(backdropPath: String) {
        binding.apply {
            val imgPosterUrl = API_BACKDROP_PATH + backdropPath
            imgPosterDetailFilm.load(imgPosterUrl) {
                scale(Scale.FILL)
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_broken_image)
                fallback(R.drawable.ic_placeholder)
                crossfade(true)
                crossfade(150)
            }
        }
    }

    private fun setupTv(title: String, releaseDate: String, description: String) {
        binding.apply {
            tvTitleDetailFilm.text = title
            tvReleaseDateDetailFilm.text = releaseDate
            tvDescriptionDetailFilm.text = description
        }
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