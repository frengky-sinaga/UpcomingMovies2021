package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.databinding.FragmentDetailBinding
import com.dicoding.upcomingmovies2021.ui.viewmodel.DetailViewModel
import com.dicoding.upcomingmovies2021.utils.EnumChip
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var result: DetailFilmEntity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailViewModel::class.java)

        arguments?.get(EXTRA_TYPE).also {
            val id = arguments?.get(EXTRA_DATA)
            result =
                if (it == TypeFilm.Movie) viewModel.getDetailMovieById(id.toString()) else viewModel.getDetailTvShowById(
                    id.toString()
                )
        }
        populateData()
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


