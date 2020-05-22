package com.android.gsixacademy.homeproject.tvShow


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.gsixacademy.homeproject.R
import com.android.gsixacademy.homeproject.models.DiscoverTvShowResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tv_show_list.view.*


class DiscoverTvShowAdapter(
val itemList : ArrayList <DiscoverTvShowResult>,
val tvShowAdapterClickEvent : (DiscoverTvShowAdapterClickEvent) -> Unit ) : RecyclerView.Adapter <RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.activity_tv_show_list,parent,false))

    }

    override fun getItemCount(): Int {
        return itemList.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(itemList [position], position)

    }
inner class MyViewHolder (view:View) : RecyclerView.ViewHolder (view){
    fun bindData (itemModel : DiscoverTvShowResult, position: Int){
        itemView.text_view_overview_tv.text = itemModel.overview
        itemView.text_view_title_tv.text = itemModel.name
        Picasso.get().load("https://image.tmdb.org/t/p/original${itemModel.poster_path}").fit().centerInside().into(itemView.image_view_poster_tv)
        itemView.tv_show_activity.setOnClickListener {
            tvShowAdapterClickEvent.invoke(DiscoverTvShowAdapterClickEvent.discoverTvShowAdapterItemClicked(itemModel))
        }
    }
}
}
