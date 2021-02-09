package com.example.myapplication.databaces.map_markers_database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.screens.map.MapMarkersData


@Dao
interface MapMarkersDatabaseDao {

    @Insert
    fun insert(markers: MapMarkersData)

    @Query("SELECT * FROM map_markers_information_table ORDER BY id DESC")
    fun getAllMarkers(): LiveData<MutableList<MapMarkersData>>


    @Query("DELETE FROM map_markers_information_table")
    fun clear()
    
}