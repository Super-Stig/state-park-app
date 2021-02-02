package com.example.myapplication.screens.news

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databaces.NewsDatabaseDao
import java.lang.IllegalArgumentException

class NewsModelFactory( private val dataSource: NewsDatabaseDao, private val application: Application): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsPageViewModel::class.java)){
            return NewsPageViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}