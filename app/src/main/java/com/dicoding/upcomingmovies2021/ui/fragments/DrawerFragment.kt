package com.dicoding.upcomingmovies2021.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dicoding.upcomingmovies2021.MainNavDirections
import com.dicoding.upcomingmovies2021.R
import com.dicoding.upcomingmovies2021.databinding.FragmentDrawerBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView

class DrawerFragment : BottomSheetDialogFragment(),
    NavigationView.OnNavigationItemSelectedListener {

    private var _binding: FragmentDrawerBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDrawerBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.navViewFragmentDrawer?.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                findNavController().navigate(MainNavDirections.actionToHomeFragment())
                dismiss()
            }
            R.id.menu_favorites -> {
                findNavController().navigate(MainNavDirections.actionToFavoritesFragment())
                dismiss()
            }
        }
        return true
    }
}