package com.dicoding.upcomingmovies2021.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.remote.models.movie.MovieResult
import com.dicoding.upcomingmovies2021.databinding.ItemsFilmBinding
import com.dicoding.upcomingmovies2021.ui.fragments.HomeFragmentDirections
import com.dicoding.upcomingmovies2021.utils.Constants
import com.dicoding.upcomingmovies2021.utils.TypeFilm

class RvMovieAdapter : RecyclerView.Adapter<RvMovieAdapter.ViewHolder>() {

    private var listDetailMovies = ArrayList<MovieResult>()

    fun setDetail(detailMovie: List<MovieResult>?) {
        if (detailMovie.isNullOrEmpty()) return
        this.listDetailMovies.clear()
        this.listDetailMovies.addAll(detailMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDetailMovies[position])
    }

    override fun getItemCount(): Int = listDetailMovies.size

    inner class ViewHolder(private val binding: ItemsFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(detailMovie: MovieResult) {
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
                            detailMovie.id,
                            TypeFilm.Movie,
                            detailMovie.title
                        )
                    it.findNavController().navigate(direction)
                }
            }
        }
    }
}