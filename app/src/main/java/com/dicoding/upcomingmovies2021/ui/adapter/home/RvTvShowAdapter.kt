package com.dicoding.upcomingmovies2021.ui.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.local.entities.tvshow.TvShowEntity
import com.dicoding.upcomingmovies2021.databinding.ItemsFilmBinding
import com.dicoding.upcomingmovies2021.ui.fragments.home.HomeFragmentDirections
import com.dicoding.upcomingmovies2021.utils.Constants
import com.dicoding.upcomingmovies2021.utils.TypeFilm

class RvTvShowAdapter : RecyclerView.Adapter<RvTvShowAdapter.ViewHolder>() {

    private var listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: List<TvShowEntity>?) {
        if (tvShows.isNullOrEmpty()) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listTvShows[position])
    }

    override fun getItemCount(): Int = listTvShows.size

    inner class ViewHolder(private val binding: ItemsFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(detailTvShow: TvShowEntity) {
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
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                            detailTvShow.tvShowId,
                            TypeFilm.TvShow,
                            detailTvShow.originalName
                        )
                    it.findNavController().navigate(direction)
                }
            }
        }
    }
}