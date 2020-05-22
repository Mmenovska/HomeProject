package com.android.gsixacademy.homeproject.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.homeproject.R
import com.android.gsixacademy.homeproject.api.ServiceBuilder
import com.android.gsixacademy.homeproject.api.TheMovieDBApi
import com.android.gsixacademy.homeproject.models.DiscoverTvShowResponse
import com.android.gsixacademy.homeproject.tvShow.DiscoverTvShowAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.image_view_logo
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchTvShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        Picasso.get().load("https://pbs.twimg.com/profile_images/1243623122089041920/gVZIvphd_400x400.jpg").fit().centerCrop().into(image_view_logo)

        button_search.setOnClickListener {
            val request = ServiceBuilder.buildService(TheMovieDBApi::class.java)
            val call = request.searchTvShow("8dd3a40cdacd660d79bce7c46bad942e", edit_text_search_bar.text.toString())

            call.enqueue(object : Callback <DiscoverTvShowResponse>{
                override fun onResponse(
                    call: Call<DiscoverTvShowResponse>,
                    response: Response<DiscoverTvShowResponse>
                ) {
                    if (response.isSuccessful){
                        val tvShow = response.body()
                        val tvShowList = tvShow?.results
                        if (tvShowList != null){
                            val tvShowAdapter = DiscoverTvShowAdapter (tvShowList){}
                            recycler_view_search.adapter = tvShowAdapter
                        }
                    }
                }

                override fun onFailure(call: Call<DiscoverTvShowResponse>, t: Throwable) {

                }

            })
        }
    }
}