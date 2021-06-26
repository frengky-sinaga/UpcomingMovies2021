package com.dicoding.upcomingmovies2021.ui.adapter.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.local.entities.movie.DetailMovieEntity
import com.dicoding.upcomingmovies2021.databinding.ItemsFilmBinding
import com.dicoding.upcomingmovies2021.ui.fragments.favorites.FavoritesFragmentDirections
import com.dicoding.upcomingmovies2021.utils.Constants
import com.dicoding.upcomingmovies2021.utils.TypeFilm

class RvMovieFavoritesAdapter : RecyclerView.Adapter<RvMovieFavoritesAdapter.ViewHolder>() {

    private var listMovies = ArrayList<DetailMovieEntity>()

    fun setMovies(movies: List<DetailMovieEntity>?) {
        if (movies.isNullOrEmpty()) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

    inner class ViewHolder(private val binding: ItemsFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(detailMovie: DetailMovieEntity) {
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
                        FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(
                            detailMovie.detailMovieId,
                            TypeFilm.Movie,
                            detailMovie.title
                        )
                    it.findNavController().navigate(direction)
                }
            }
        }
    }
}