package com.android.gsixacademy.homeproject.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.gsixacademy.homeproject.R
import com.android.gsixacademy.homeproject.models.DiscoverMoviesResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_list.view.*

class DiscoverMoviesAdapter (
    val itemList : ArrayList <DiscoverMoviesResult>,
    val moviesAdapterClickEvent : (DiscoverMoviesAdapterClickEvent) -> Unit ) : RecyclerView.Adapter <RecyclerView.ViewHolder>()
 {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         return MyViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.activity_movie_list,parent,false))
     }

     override fun getItemCount(): Int {
        return itemList.size
     }

     override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    var myViewHolder = holder as MyViewHolder
         myViewHolder.bindData(itemList [position], position)

     }
     inner class MyViewHolder (view : View) : RecyclerView.ViewHolder (view){
         fun bindData (itemModel : DiscoverMoviesResult, position: Int){
             itemView.text_view_title.text = itemModel.title
             itemView.text_view_overview.text = itemModel.overview
             Picasso.get().load("https://image.tmdb.org/t/p/w500${itemModel.poster_path}").fit().fit().into(itemView.image_view_poster)
             itemView.movie_list_activity.setOnClickListener {
            moviesAdapterClickEvent.invoke(DiscoverMoviesAdapterClickEvent.DiscoverMoviesItemClicked(itemModel))
             }
         }
     }

 }