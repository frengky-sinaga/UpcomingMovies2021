package com.dicoding.upcomingmovies2021.ui.adapter.favorites

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
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.DetailTvShowEntity
import com.dicoding.upcomingmovies2021.databinding.ItemsFilmBinding
import com.dicoding.upcomingmovies2021.ui.fragments.favorites.FavoritesFragmentDirections
import com.dicoding.upcomingmovies2021.utils.Constants
import com.dicoding.upcomingmovies2021.utils.TypeFilm

class RvTvShowFavoritesAdapter :
    PagedListAdapter<DetailTvShowEntity, RvTvShowFavoritesAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DetailTvShowEntity>() {
            override fun areItemsTheSame(
                oldItem: DetailTvShowEntity,
                newItem: DetailTvShowEntity
            ): Boolean {
                return oldItem.detailTvShowId == newItem.detailTvShowId
            }

            override fun areContentsTheSame(
                oldItem: DetailTvShowEntity,
                newItem: DetailTvShowEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShowFavorite = getItem(position)
        if (tvShowFavorite != null) holder.bind(tvShowFavorite)
    }

    inner class ViewHolder(private val binding: ItemsFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(detailTvShow: DetailTvShowEntity) {
            with(binding) {
                val urlPoster = Constants.API_POSTER_PATH + detailTvShow.posterPath
                imgPoster.load(urlPoster) {
                    scale(Scale.FIT)
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(true)
                    crossfade(500)
                    transformations(RoundedCornersTransformation(20f))
                }
                tvItemTitle.text = detailTvShow.name
                tvItemDate.text = detailTvShow.firstAirDate

                itemView.setOnClickListener {
                    val direction =
                        FavoritesFragmentDirections.actionFavoritesFragmentToDetailFragment(
                            detailTvShow.detailTvShowId,
                            TypeFilm.TvShow,
                            detailTvShow.originalName
                        )
                    it.findNavController().navigate(direction)
                }
            }
        }
    }
}