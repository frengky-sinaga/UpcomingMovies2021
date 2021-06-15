package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvShowResult
import com.dicoding.upcomingmovies2021.databinding.FragmentTvShowBinding
import com.dicoding.upcomingmovies2021.ui.adapter.RvTvShowAdapter
import com.dicoding.upcomingmovies2021.ui.interfaces.OnTvShowItemClickCallback
import com.dicoding.upcomingmovies2021.ui.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment(R.layout.fragment_tv_show), OnTvShowItemClickCallback {

    lateinit var binding: FragmentTvShowBinding
    private val viewModel: TvShowViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTvShowBinding.bind(view)

        setAdapter()
    }

    private fun setAdapter() {
        viewModel.tvShowResponse.observe(viewLifecycleOwner, { data ->
            val tvShowAdapter = RvTvShowAdapter(this)
            tvShowAdapter.setDetail(data)
            with(binding.rvTvShow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        })
    }

    override fun onItemClicked(data: TvShowResult) {
        TODO("Not yet implemented")
    }
}