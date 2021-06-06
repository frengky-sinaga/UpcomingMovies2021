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
import com.dicoding.upcomingmovies2021.databinding.FragmentDetailBinding
import com.dicoding.upcomingmovies2021.ui.viewmodel.FilmViewModel
import com.dicoding.upcomingmovies2021.utils.EnumChip
import com.google.android.material.chip.Chip

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: FilmViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity()).get(FilmViewModel::class.java)

        viewModel.getDataFilm().observe(viewLifecycleOwner, { data ->
            binding.tvTitle.text = data.title
            binding.tvReleaseDate.text = data.releaseDate
            binding.contentDescription.text = data.description
            binding.imgPoster.load(data.poster) {
                scale(Scale.FIT)
                placeholder(R.drawable.ic_placeholder)
                crossfade(true)
                crossfade(400)
                transformations(GrayscaleTransformation())
            }
            binding.imgIcon.load(data.poster) {
                placeholder(R.drawable.ic_placeholder)
                transformations(CircleCropTransformation())
            }
            for (genre in data.genre) {
                createChip(genre.toString(), EnumChip.Genre)
            }
            for (star in data.crews.stars) {
                createChip(star, EnumChip.Star)
            }
            val visible = View.VISIBLE
            if (data.crews.directors != null) {
                binding.tvDirectors.visibility = visible
                binding.chipDirectors.visibility = visible
                for (director in data.crews.directors!!) {
                    createChip(director, EnumChip.Director)
                }
            }
            if (data.crews.writers != null) {
                binding.chipWriters.visibility = visible
                binding.tvWriters.visibility = visible
                for (writer in data.crews.writers!!) {
                    createChip(writer, EnumChip.Writer)
                }
            }
            if (data.crews.creators != null) {
                binding.chipCreators.visibility = visible
                binding.tvCreators.visibility = visible
                for (creator in data.crews.creators!!) {
                    createChip(creator, EnumChip.Creator)
                }
            }
        })
    }

    private fun createChip(txt: String, enumChip: EnumChip) {
        val chip = Chip(context)
        chip.apply {
            text = txt
            isChipIconVisible = false
            isCloseIconVisible = false
            isClickable = false
            isCheckable = false

            when (enumChip) {
                EnumChip.Genre -> binding.chipGenre.addView(chip)
                EnumChip.Director -> binding.chipDirectors.addView(chip)
                EnumChip.Star -> binding.chipStars.addView(chip)
                EnumChip.Writer -> binding.chipWriters.addView(chip)
                EnumChip.Creator -> binding.chipCreators.addView(chip)
            }
        }
    }
}