package com.example.myapplication.screens.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.R
import com.example.myapplication.databaces.NewsDatabaseDao
import com.example.myapplication.screens.news.recylerview.NewsAdaptorData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext

class NewsPageViewModel(val database:NewsDatabaseDao, application:Application):AndroidViewModel(application) {

    private var _listOfNewsObjectsToCastToView = database.getListOfNewsArticals()
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


    val FILLER_CONTENT:String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    val FILLER_DATA = NewsAdaptorData(1L,"New Something Found", R.drawable.ic_park, FILLER_CONTENT)
//    fun setListOfNewsObjectsToCastToView(){
//        _listOfNewsObjectsToCastToView.value = listOf<NewsAdaptorData>(FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA)
//       Toast.makeText(context, "List Cast: ${_listOfNewsObjectsToCastToView.value?.size}",Toast.LENGTH_SHORT).show()
//    }






}