package com.example.myapplication.screens.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databaces.NewsDatabase
import com.example.myapplication.databinding.NewsPageFragmentBinding
import com.example.myapplication.screens.news.recylerview.NewsAdaptor

class NewsPageFragment:Fragment() {

   // lateinit var binding: NewsPageFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       val binding :NewsPageFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.news_page_fragment,container,false)
        ///
        ///
        ///
        val application = requireNotNull(this.activity).application
        val dataSource = NewsDatabase.getInstance(application).newsDatabaseDao
        val viewModelFactory = NewsModelFactory(dataSource,application)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(NewsPageViewModel::class.java)
        

       // viewModel.setListOfNewsObjectsToCastToView()


        val recyclerView = binding.newsPageRecylerView
        val adapter = NewsAdaptor()

        recyclerView.adapter = adapter

        viewModel.listOfNewsObjectsToCastToView().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            }
        })

        viewModel.setNewsArticleList()




        binding.viewModel = viewModel



        binding.lifecycleOwner = this

        //
        //
        //
        return binding.root
    }

}