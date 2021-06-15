package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.databinding.FragmentFilmBinding
import com.dicoding.upcomingmovies2021.ui.OnItemClickCallback
import com.dicoding.upcomingmovies2021.ui.adapter.RvAdapter
import com.dicoding.upcomingmovies2021.ui.viewmodel.FilmViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmFragment : Fragment(R.layout.fragment_film), OnItemClickCallback {

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(index: Int) =
            FilmFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    private lateinit var binding: FragmentFilmBinding
    private val viewModel: FilmViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilmBinding.bind(view)

        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        if (index != null) {
            setAdapter(index)
        }
    }

    private fun setAdapter(index: Int) {
        val filmList = if (index == 1) viewModel.getDataMovie() else viewModel.getDataTvShow()
        val filmAdapter = RvAdapter(this)
        filmAdapter.setDetail(filmList)

        with(binding.rvFilm) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = filmAdapter
        }
    }

    override fun onItemClicked(data: DetailFilmEntity) {
        /*val bundle = Bundle()
        bundle.putString(DetailFragment.EXTRA_DATA, data.idFilm)
        bundle.putSerializable(DetailFragment.EXTRA_TYPE, data.typeFilm)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        val fm = activity?.supportFragmentManager
        fm?.beginTransaction()?.apply {
            replace(
                R.id.main_container,
                detailFragment,
                DetailFragment::class.java.simpleName
            )
            addToBackStack(null)
            commit()
        }*/
    }
}