package com.dicoding.upcomingmovies2021.ui.fragments.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.databinding.FragmentTvShowBinding
import com.dicoding.upcomingmovies2021.ui.adapter.home.RvTvShowAdapter
import com.dicoding.upcomingmovies2021.ui.fragments.SortDialogFragment
import com.dicoding.upcomingmovies2021.ui.viewmodel.TvShowViewModel
import com.dicoding.upcomingmovies2021.utils.TypeFilm
import com.dicoding.upcomingmovies2021.vo.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TvShowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        setupObservers()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_film, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                activity?.finish()
                true
            }
            R.id.menu_open_sort_dialog -> {
                setupSortDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupObservers() {
        viewModel.getTvShows().observe(viewLifecycleOwner, { resources ->
            when (resources.status) {
                Resource.Status.SUCCESS -> {
                    dismissLoading()
                    resources.data?.let {
                        setupRv(it)
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
        })
    }

    private fun setupRv(data: List<TvShowEntity>) {
        val tvShowAdapter = RvTvShowAdapter()
        tvShowAdapter.setTvShows(data)
        with(binding.rvTvShow) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

    private fun showLoading() {
        binding.apply {
            progressTvShow.visibility = View.VISIBLE
        }
    }

    private fun dismissLoading() {
        binding.apply {
            progressTvShow.visibility = View.GONE
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    private fun setupSortDialog() {
        val sortDialogFragment = SortDialogFragment.newInstance(TypeFilm.TvShow)
        sortDialogFragment.show(childFragmentManager, SortDialogFragment.TAG)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}