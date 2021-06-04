package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.databinding.FragmentFilmBinding
import com.dicoding.upcomingmovies2021.ui.adapter.RvAdapter
import com.dicoding.upcomingmovies2021.ui.viewmodel.FilmViewModel

class FilmFragment : Fragment(R.layout.fragment_film) {

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
    private lateinit var viewModel: FilmViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilmBinding.bind(view)

        viewModel = ViewModelProvider(requireActivity()).get(FilmViewModel::class.java)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        if (index != null) {
            setAdapter(index)
        }
    }

    private fun setAdapter(index: Int) {
        val filmList = viewModel.getDataDummy(index)

        val filmAdapter = RvAdapter()
        filmAdapter.setDetail(filmList)

        with(binding.rvMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = filmAdapter

            filmAdapter.setOnItemClickCallback(object : RvAdapter.OnItemClickCallback{
                override fun onItemClicked(data: DetailFilmEntity) {
                    viewModel.setDataFilm(data)

                    val fm = activity?.supportFragmentManager
                    val detailFragment = DetailFragment()

                    fm?.beginTransaction()?.apply {
                        replace(R.id.main_container, detailFragment, DetailFragment::class.java.simpleName)
                        addToBackStack(null)
                        commit()
                    }
                }
            })
        }
    }
}