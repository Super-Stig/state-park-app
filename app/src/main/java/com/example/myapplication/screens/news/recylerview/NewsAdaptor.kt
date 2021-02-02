package com.example.myapplication.screens.news.recylerview

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.NewsLayoutForAdaptorBinding

class NewsAdaptor: ListAdapter<NewsAdaptorData, NewsAdaptor.AlternativeCounterViewHolder>(NewsDiffCallback()) {


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlternativeCounterViewHolder {
        val view = NewsLayoutForAdaptorBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AlternativeCounterViewHolder(view)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: AlternativeCounterViewHolder, position: Int) {
        holder.bind(position, holder)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    inner class AlternativeCounterViewHolder(val binding: NewsLayoutForAdaptorBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int, holder: AlternativeCounterViewHolder) {
            val item = getItem(position)

            holder.binding.contentDescription.text = item.content
            holder.binding.newsHeader.text = item.name
            holder.binding.iconForNews.setImageResource(item.iconResource)

        }
    }


    class NewsDiffCallback: DiffUtil.ItemCallback<NewsAdaptorData>(){
        override fun areItemsTheSame(oldItem: NewsAdaptorData, newItem: NewsAdaptorData): Boolean {
            return  oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: NewsAdaptorData, newItem: NewsAdaptorData): Boolean {
            return oldItem == newItem
        }

    }

}