package com.dicoding.upcomingmovies2021.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.data.DetailFilmEntity
import com.dicoding.upcomingmovies2021.databinding.ItemsFilmBinding
import com.dicoding.upcomingmovies2021.ui.OnItemClickCallback

class RvAdapter(private val onItemClickCallback: OnItemClickCallback) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    private var listDetailFilms = ArrayList<DetailFilmEntity>()

    fun setDetail(detailFilm: List<DetailFilmEntity>?) {
        if (detailFilm.isNullOrEmpty()) return
        this.listDetailFilms.clear()
        this.listDetailFilms.addAll(detailFilm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listDetailFilms[position])
    }

    override fun getItemCount(): Int = listDetailFilms.size

    inner class ViewHolder(private val binding: ItemsFilmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(detailFilm: DetailFilmEntity) {
            with(binding) {
                imgPoster.load(detailFilm.poster) {
                    scale(Scale.FIT)
                    placeholder(R.drawable.ic_placeholder)
                    crossfade(true)
                    crossfade(500)
                    transformations(RoundedCornersTransformation(20f))
                }
                tvItemTitle.text = detailFilm.title
                tvItemDate.text = detailFilm.releaseDate

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(detailFilm)
                }
            }
        }
    }
}