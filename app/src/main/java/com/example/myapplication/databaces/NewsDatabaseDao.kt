package com.example.myapplication.databaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.screens.news.recylerview.NewsAdaptorData


@Dao
interface NewsDatabaseDao{

    @Insert
    fun insert(news:NewsAdaptorData)

    @Update
    fun update(news:NewsAdaptorData)

    @Query("SELECT * from news_data_for_adaptor_to_cast_to_view WHERE newsId = :key")
    fun get(key:Long):NewsAdaptorData

    @Query("DELETE FROM news_data_for_adaptor_to_cast_to_view")
    fun clear()

    @Query("SELECT * FROM news_data_for_adaptor_to_cast_to_view ORDER BY newsId DESC")
    fun getListOfNewsArticals():LiveData<List<NewsAdaptorData>>

}