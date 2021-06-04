package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
    }
}