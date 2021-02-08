package com.example.myapplication.screens.map

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.databaces.map_markers_database.MapMarkersDatabaseDao

class MapPageViewModel(private val database: MapMarkersDatabaseDao, application: Application):AndroidViewModel(application) {

    private val _listOfAllMarkers = database.getAllMarkers()
    fun listOfAllMarkers():List<MapMarkersData> = _listOfAllMarkers

    fun addMarker(data:MapMarkersData){
        database.insert(data)
    }

    fun clearAllData(){
        database.clear()
    }

}