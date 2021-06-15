package com.dicoding.upcomingmovies2021.ui.interfaces

import com.dicoding.upcomingmovies2021.data.source.remote.models.tvshow.TvShowResult

interface OnTvShowItemClickCallback {
    fun onItemClicked(data: TvShowResult)
}