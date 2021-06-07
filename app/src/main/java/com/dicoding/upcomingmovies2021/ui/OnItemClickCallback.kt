package com.dicoding.upcomingmovies2021.ui

import com.dicoding.upcomingmovies2021.data.DetailFilmEntity

interface OnItemClickCallback {
    fun onItemClicked(data: DetailFilmEntity)
}