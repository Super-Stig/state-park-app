package com.example.myapplication.databaces.map_markers_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.screens.map.MapMarkersData


@Database(entities = [MapMarkersData::class], version = 3, exportSchema = false)
abstract class MapMarkersDatabase: RoomDatabase() {

    abstract val  mapMarkersDatabaseDao: MapMarkersDatabaseDao

    companion object{

        @Volatile
        private var INSTANCE: MapMarkersDatabase? = null

        fun getInstance(context:Context): MapMarkersDatabase {

            synchronized(this){
                var instance = MapMarkersDatabase.INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder( context.applicationContext, MapMarkersDatabase::class.java, "news_feed_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    MapMarkersDatabase.INSTANCE = instance
                }

                return instance
            }
        }
    }
}