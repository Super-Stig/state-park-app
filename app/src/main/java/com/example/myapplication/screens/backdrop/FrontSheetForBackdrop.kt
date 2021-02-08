package com.example.myapplication.screens.backdrop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FrontSheetForBackdropBinding
import com.example.myapplication.screens.homepage.HomePageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FrontSheetForBackdrop:BottomSheetDialogFragment() {

    private var curState:Int = BottomSheetBehavior.STATE_EXPANDED
    lateinit var binding: FrontSheetForBackdropBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FrontSheetForBackdropBinding.inflate(inflater,container,false)
        ///
        ///
        ///

        val navView = binding.navigationButtonHolder




        navView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home_menu_item -> Navigation.findNavController(binding.navView).navigate(R.id.homePageFragment)
                R.id.maps_menu_item -> Navigation.findNavController(binding.navView).navigate(R.id.mapsPageFragment)
                R.id.news_menu_item -> Navigation.findNavController(binding.navView).navigate(R.id.newsPageFragment)
                R.id.resources_menu_item -> Navigation.findNavController(binding.navView).navigate(R.id.resPageFragment)
            }
            true
        }


        //
        //
        //
        return binding.root
    }

}