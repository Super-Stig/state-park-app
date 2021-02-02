package com.example.myapplication.screens.news.recylerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.R
import java.util.jar.Attributes

@Entity(tableName = "news_data_for_adaptor_to_cast_to_view")
data class NewsAdaptorData (

        @PrimaryKey(autoGenerate = true)
        val newsId: Long = 0L,

        @ColumnInfo(name = "article_title")
        val name: String = "Title Needed",

        @ColumnInfo(name = "img_resource_location")
        val iconResource: Int = R.drawable.ic_park,

        @ColumnInfo(name = "article_description")
        val content: String = "Content Not Found"
        )