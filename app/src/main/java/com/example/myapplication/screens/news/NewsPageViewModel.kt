package com.example.myapplication.screens.news

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.R
import com.example.myapplication.screens.news.recylerview.NewsAdaptorData

class NewsPageViewModel:ViewModel() {

    private var _listOfNewsObjectsToCastToView = MutableLiveData<List<NewsAdaptorData>>()
    fun listOfNewsObjectsToCastToView(): LiveData<List<NewsAdaptorData>> = _listOfNewsObjectsToCastToView

    val FILLER_CONTENT:String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    val FILLER_DATA = NewsAdaptorData("New Speasies Found", R.drawable.ic_park, FILLER_CONTENT)
    fun setListOfNewsObjectsToCastToView(context:Context){
        _listOfNewsObjectsToCastToView.value = listOf<NewsAdaptorData>(FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA,FILLER_DATA)
        Toast.makeText(context, "List Cast: ${_listOfNewsObjectsToCastToView.value?.size}",Toast.LENGTH_SHORT).show()
    }






}