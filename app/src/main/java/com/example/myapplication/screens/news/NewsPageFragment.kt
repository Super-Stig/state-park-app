package com.example.myapplication.screens.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.NewsPageFragmentBinding
import com.example.myapplication.screens.news.recylerview.NewsAdaptor

class NewsPageFragment:Fragment() {

    lateinit var binding: NewsPageFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = NewsPageViewModel()
        binding = NewsPageFragmentBinding.inflate(inflater,container,false)
        ///
        ///
        ///


        val recyclerView = binding.newsPageRecylerView
        val adapter = NewsAdaptor()

        recyclerView.adapter = adapter

        viewModel.listOfNewsObjectsToCastToView().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            }
        })








        //
        //
        //
        return binding.root
    }

}