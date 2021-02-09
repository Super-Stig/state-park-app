package com.example.myapplication.screens.map

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng


@Entity(tableName = "Map_markers_information_table")
data class MapMarkersData(

    @ColumnInfo
    val name: String = "Needs Name",

    @ColumnInfo
    val latitude:Double = 0.0,

    @ColumnInfo
    val longitude:Double = 0.0,

    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L

)
