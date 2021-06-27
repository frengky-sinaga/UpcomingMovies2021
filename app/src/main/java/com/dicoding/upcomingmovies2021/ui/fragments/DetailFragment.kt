package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import coil.size.Scale
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentDetailBinding
import com.dicoding.upcomingmovies2021.ui.viewmodel.DetailViewModel
import com.dicoding.upcomingmovies2021.utils.Constants.API_BACKDROP_PATH
import com.dicoding.upcomingmovies2021.vo.Resource
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding
    private var fab: FloatingActionButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        val extraTypeFilm = args.extraTypeFilm
        val extraTitle = args.extraTitle
        val extraId = args.extraId
        viewModel.setData(extraTypeFilm, extraId)

        if (extraTypeFilm == TypeFilm.Movie) setupDetailMovieObservers()
        else if (extraTypeFilm == TypeFilm.TvShow) setupDetailTvShowObservers()

        setupToolbar(extraTitle)
    }

    private fun setupDetailMovieObservers() {
        viewModel.movieDetail?.observe(viewLifecycleOwner, { resources ->
            var fabStatus = false
            when (resources.status) {
                Resource.Status.SUCCESS -> {
                    dismissLoading()
                    resources.data?.let { data ->
                        data.overview?.let { setupTv(data.originalTitle, data.releaseDate, it) }
                        data.backdropPath?.let { setupImg(it) }
                        for (genre in data.genre) {
                            createChip(genre.genreName, 0)
                        }
                        for (company in data.companies) {
                            createChip(company.companyName, 1)
                        }
                        fabStatus = data.favorite
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
            fabListener(TypeFilm.Movie, fabStatus)
        })
    }

    private fun setupDetailTvShowObservers() {
        viewModel.tvShowDetail?.observe(viewLifecycleOwner, { resources ->
            var fabStatus = false
            when (resources.status) {
                Resource.Status.SUCCESS -> {
                    dismissLoading()
                    resources.data?.let { data ->
                        setupTv(data.originalName, data.firstAirDate, data.overview)
                        data.backdropPath?.let { setupImg(it) }
                        for (genre in data.genre) {
                            createChip(genre.genreName, 0)
                        }
                        for (company in data.companies) {
                            createChip(company.companyName, 1)
                        }
                        fabStatus = data.favorite
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
            fabListener(TypeFilm.TvShow, fabStatus)
        })
    }

    private fun setupToolbar(title: String) {
        binding.apply {
            (requireActivity() as AppCompatActivity).setSupportActionBar(toolbarDetailFilm)
            toolbarDetailFilm.setNavigationIcon(R.drawable.ic_back)
            toolbarDetailFilm.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            toolbarDetailFilm.title = title
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
            if (type == 0) {
                binding.chipGenreDetailFilm.removeAllViews()
                binding.chipGenreDetailFilm.addView(chip)
            }
            else if (type == 1) {
                binding.chipProductionCompanyDetailFilm.removeAllViews()
                binding.chipProductionCompanyDetailFilm.addView(chip)
            }
        }
    }

    private fun showLoading() {
        binding.apply {
            progressDetail.visibility = View.VISIBLE
        }
    }

    private fun dismissLoading() {
        binding.apply {
            progressDetail.visibility = View.GONE
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    private fun fabListener(typeFilm: TypeFilm, status: Boolean) {
        binding.fabDetail.apply {
            setImgFab(status)
            setOnClickListener {
                if (typeFilm == TypeFilm.Movie) viewModel.setMovieFavorite()
                else viewModel.setTvShowFavorite()
            }
        }
    }

    private fun setImgFab(status: Boolean) {
        binding.fabDetail.apply {
            setImageDrawable(
                if (status) {
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_favorite
                    )
                } else {
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.ic_favorite_border
                    )
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fab = null
    }
}