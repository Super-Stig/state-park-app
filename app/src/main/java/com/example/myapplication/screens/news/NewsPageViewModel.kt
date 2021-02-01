package com.example.myapplication.screens.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.screens.news.recylerview.NewsAdaptorData

class NewsPageViewModel:ViewModel() {

    private var _listOfNewsObjectsToCastToView = MutableLiveData<MutableList<NewsAdaptorData>>()
    fun listOfNewsObjectsToCastToView(): LiveData<MutableList<NewsAdaptorData>> = _listOfNewsObjectsToCastToView






}