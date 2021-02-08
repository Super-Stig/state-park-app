package com.example.myapplication.screens.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.R
import com.example.myapplication.databaces.NewsDatabaseDao
import com.example.myapplication.screens.news.recylerview.NewsAdaptorData
import kotlinx.coroutines.*

class NewsPageViewModel(private val database:NewsDatabaseDao, application:Application):AndroidViewModel(application) {

    private var _listOfNewsObjectsToCastToView = database.getListOfNewsArticles()
    fun listOfNewsObjectsToCastToView(): LiveData<List<NewsAdaptorData>> = _listOfNewsObjectsToCastToView


    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)





    private suspend fun insert(article:NewsAdaptorData){
        withContext(Dispatchers.IO){
            database.insert(article)
        }
    }

    fun setNewsArticleList(){
        viewModelScope.launch {
            val FILLER_DATA = NewsAdaptorData()
            insert(FILLER_DATA)
        }
    }

}