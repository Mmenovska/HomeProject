package com.android.gsixacademy.homeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.gsixacademy.homeproject.R
import com.android.gsixacademy.homeproject.movies.DiscoverMoviesActivity
import com.android.gsixacademy.homeproject.search.SearchMovieActivity
import com.android.gsixacademy.homeproject.search.SearchTvShowActivity
import com.android.gsixacademy.homeproject.tvShow.DiscoverTvShowActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var listViewActivites : ArrayList <String> = arrayListOf("DiscoverMoviesActivity", "DiscoverTvShowActivity", "SearchMovieActivity", "SearchTvShowActivity" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Picasso.get().load("https://pbs.twimg.com/profile_images/1243623122089041920/gVZIvphd_400x400.jpg").fit().centerCrop().into(image_view_logo)

        var activitesAdapten = ArrayAdapter (this, android.R.layout.simple_list_item_1,listViewActivites)
        list_view_main.adapter = activitesAdapten

        list_view_main.setOnItemClickListener { adapterView, view, i, l ->
            var className = listViewActivites [i]
            Toast.makeText(applicationContext, className, Toast.LENGTH_LONG).show()
            when (className) {
                "DiscoverMoviesActivity" -> startActivity(Intent(applicationContext, DiscoverMoviesActivity::class.java))
                "DiscoverTvShowActivity" -> startActivity(Intent(applicationContext, DiscoverTvShowActivity ::class.java))
                "SearchMovieActivity" -> startActivity(Intent(applicationContext, SearchMovieActivity::class.java))
                "SearchTvShowActivity" -> startActivity(Intent(applicationContext, SearchTvShowActivity :: class.java))
            }
        }
    }
}
