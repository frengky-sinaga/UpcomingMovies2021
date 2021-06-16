package com.dicoding.upcomingmovies2021.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvShowResult
import com.dicoding.upcomingmovies2021.databinding.ItemsFilmBinding
import com.dicoding.upcomingmovies2021.ui.fragments.HomeFragmentDirections
import com.dicoding.upcomingmovies2021.utils.Constants
import com.dicoding.upcomingmovies2021.utils.TypeFilm

class RvTvShowAdapter : RecyclerView.Adapter<RvTvShowAdapter.ViewHolder>() {

    private var listDetailTvShows = ArrayList<TvShowResult>()

    fun setDetail(detailTvShow: List<TvShowResult>?) {
        if (detailTvShow.isNullOrEmpty()) return
        this.listDetailTvShows.clear()
        this.listDetailTvShows.addAll(detailTvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDetailTvShows[position])
    }

    override fun getItemCount(): Int = listDetailTvShows.size

    inner class ViewHolder(private val binding: ItemsFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(detailTvShow: TvShowResult) {
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
                            detailTvShow.id,
                            TypeFilm.TvShow
                        )
                    it.findNavController().navigate(direction)
                }
            }
        }
    }
}