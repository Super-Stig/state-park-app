package com.example.myapplication.databaces.map_markers_database

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.screens.map.MapMarkersData


@Dao
interface MapMarkersDatabaseDao {

    @Insert
    fun insert(marker: MapMarkersData)

    @Query("SELECT * FROM map_markers_information_table ORDER BY `key` DESC")
    fun getAllMarkers(): List<MapMarkersData>


    @Query("DELETE FROM map_markers_information_table")
    fun clear()
    
}