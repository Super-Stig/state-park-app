package com.example.myapplication.screens.backdrop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FrontSheetForBackdropBinding
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
            when(MenuItem){
                else ->
            }
        }












        //
        //
        //
        return binding.root
    }

}