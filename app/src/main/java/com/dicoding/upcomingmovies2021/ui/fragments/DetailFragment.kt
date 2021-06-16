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
import com.dicoding.upcomingmovies2021.databinding.FragmentDetailBinding
import com.dicoding.upcomingmovies2021.ui.viewmodel.DetailViewModel
import com.dicoding.upcomingmovies2021.utils.Constants.API_BACKDROP_PATH
import com.dicoding.upcomingmovies2021.utils.Constants.API_POSTER_PATH
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
            Log.d("movieDb", detailMovie.title)
            binding.apply {
                tvTitle.text = detailMovie.title
                tvReleaseDate.text = detailMovie.releaseDate
                contentDescription.text = detailMovie.overview

                val imgPosterUrl = API_BACKDROP_PATH + detailMovie.backdropPath
                imgPoster.load(imgPosterUrl){
                    scale(Scale.FILL)
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(true)
                    crossfade(400)
                    transformations(GrayscaleTransformation())
                }

                val imgIconUrl = API_POSTER_PATH + detailMovie.posterPath
                imgIcon.load(imgIconUrl){
                    placeholder(R.drawable.ic_placeholder)
                    transformations(CircleCropTransformation())
                }

                for (genre in detailMovie.genres){
                    createChip(genre.name)
                }
            }
        })
    }

    private fun populateTvShow() {
        viewModel.tvShowDetail.observe(viewLifecycleOwner, { detailTvShow ->
            Log.d("movieDb", detailTvShow.originalName)

            binding.apply {
                tvTitle.text = detailTvShow.originalName
                tvReleaseDate.text = detailTvShow.firstAirDate
                contentDescription.text = detailTvShow.overview

                val imgPosterUrl = API_BACKDROP_PATH + detailTvShow.backdropPath
                imgPoster.load(imgPosterUrl){
                    scale(Scale.FILL)
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(true)
                    crossfade(400)
                    transformations(GrayscaleTransformation())
                }

                val imgIconUrl = API_POSTER_PATH + detailTvShow.posterPath
                imgIcon.load(imgIconUrl){
                    placeholder(R.drawable.ic_placeholder)
                    transformations(CircleCropTransformation())
                }

                for (genre in detailTvShow.genres){
                    createChip(genre.name)
                }
            }
        })
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