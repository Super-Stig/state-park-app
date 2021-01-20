package com.example.myapplication.screens.homepage


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.HomePageFragmentBinding


class HomePageFragment : Fragment() {

    lateinit var binding:HomePageFragmentBinding

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