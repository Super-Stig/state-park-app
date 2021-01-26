package com.example.myapplication.screens.homepage


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.HomePageFragmentBinding
import com.example.myapplication.screens.backdrop.FrontSheetForBackdrop


class HomePageFragment : Fragment() {

    lateinit var binding:HomePageFragmentBinding
    lateinit var backdropController:FrontSheetForBackdrop

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomePageFragmentBinding.inflate(inflater)
        val viewModel = HomePageViewModel()




        return binding.root
    }

}