package com.dicoding.upcomingmovies2021.ui.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.MovieEntity
import com.dicoding.upcomingmovies2021.databinding.ItemsFilmBinding
import com.dicoding.upcomingmovies2021.ui.fragments.home.HomeFragmentDirections
import com.dicoding.upcomingmovies2021.utils.Constants
import com.dicoding.upcomingmovies2021.utils.TypeFilm

class RvMovieAdapter : PagedListAdapter<MovieEntity, RvMovieAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) holder.bind(movie)
    }

    inner class ViewHolder(private val binding: ItemsFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(detailMovie: MovieEntity) {
            with(binding) {
                val urlPoster = Constants.API_POSTER_PATH + detailMovie.posterPath
                imgPoster.load(urlPoster) {
                    scale(Scale.FIT)
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(true)
                    crossfade(500)
                    transformations(RoundedCornersTransformation(20f))
                }
                tvItemTitle.text = detailMovie.title
                tvItemDate.text = detailMovie.releaseDate

                itemView.setOnClickListener {
                    val direction =
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                            detailMovie.movieId,
                            TypeFilm.Movie,
                            detailMovie.title
                        )
                    it.findNavController().navigate(direction)
                }
            }
        }
    }
}