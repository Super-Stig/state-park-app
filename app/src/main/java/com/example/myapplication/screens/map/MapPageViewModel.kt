package com.example.myapplication.screens.map

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.databaces.map_markers_database.MapMarkersDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MapPageViewModel(private val database: MapMarkersDatabaseDao, application: Application):AndroidViewModel(application) {

    private var _listOfAllMarkers = database.getAllMarkers()
    fun listOfAllMarkers():LiveData<MutableList<MapMarkersData>> = _listOfAllMarkers


    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun addMarker(data:MapMarkersData){
        Log.d("MapDatabase","List of all Markers: ${database.getAllMarkers().value}")

        viewModelScope.launch{
            insert(data)
        }

    }

    private suspend fun insert(data:MapMarkersData){
        withContext(Dispatchers.IO){
            Log.d("MapDatabase","data: $data}")
            database.insert(data)
        }
    }

    fun clearAllData(){
        database.clear()
    }

}