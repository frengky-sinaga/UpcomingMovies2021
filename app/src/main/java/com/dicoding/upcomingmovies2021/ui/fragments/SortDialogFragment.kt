package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.dicoding.upcomingmovies2021.databinding.FragmentSortDialogBinding
import com.dicoding.upcomingmovies2021.ui.viewmodel.MovieViewModel
import com.dicoding.upcomingmovies2021.ui.viewmodel.TvShowViewModel
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SortDialogFragment : DialogFragment() {

    private val movieViewModel: MovieViewModel by viewModels()
    private val tvShowViewModel: TvShowViewModel by viewModels()
    private var _binding: FragmentSortDialogBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG = "SortDialogFragment"

        private const val TYPE_FILM = "type_film"

        fun newInstance(type: TypeFilm): SortDialogFragment {
            val args = Bundle()
            args.putSerializable(TYPE_FILM, type)
            val fragment = SortDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSortDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnMovieSortNo.setOnClickListener {
                dismiss()
            }
            btnMovieSortYes.setOnClickListener {
                val radioBtnId = rgMovieSort.checkedRadioButtonId
                val sortType = if (radioBtnId == rbMovieSortName.id) "name" else "release date"

                val typeFilm = arguments?.get(TYPE_FILM)
                if (typeFilm == TypeFilm.Movie) {
                    movieViewModel.sortMovies(sortType)
                } else {
                    tvShowViewModel.sortTvShows(sortType)
                }
                dismiss()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}