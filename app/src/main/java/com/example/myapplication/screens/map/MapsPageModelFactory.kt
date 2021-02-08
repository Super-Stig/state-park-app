package com.example.myapplication.screens.map

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databaces.map_markers_database.MapMarkersDatabaseDao
import java.lang.IllegalArgumentException


class MapsPageModelFactory(private val dataSource: MapMarkersDatabaseDao,private val application: Application):ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MapPageViewModel::class.java)){
            return MapPageViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}