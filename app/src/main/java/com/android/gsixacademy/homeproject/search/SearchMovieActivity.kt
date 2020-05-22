package com.android.gsixacademy.homeproject.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.homeproject.R
import com.android.gsixacademy.homeproject.api.ServiceBuilder
import com.android.gsixacademy.homeproject.api.TheMovieDBApi
import com.android.gsixacademy.homeproject.models.DiscoverMoviesResponse
import com.android.gsixacademy.homeproject.movies.DiscoverMoviesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.image_view_logo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Picasso.get().load("https://pbs.twimg.com/profile_images/1243623122089041920/gVZIvphd_400x400.jpg").fit().centerCrop().into(image_view_logo)


        button_search.setOnClickListener {
            val request = ServiceBuilder.buildService(TheMovieDBApi::class.java)
            val call = request.searchMovies("8dd3a40cdacd660d79bce7c46bad942e", edit_text_search_bar.text.toString())

            call.enqueue(object : Callback <DiscoverMoviesResponse> {
                override fun onResponse(
                    call: Call<DiscoverMoviesResponse>,
                    response: Response<DiscoverMoviesResponse>
                ) { if (response.isSuccessful){
                    val movieResult = response.body()
                    val movieResultList = movieResult?.results
                    if (movieResultList != null){
                        val movieAdapter = DiscoverMoviesAdapter (movieResultList){}
                        recycler_view_search.adapter = movieAdapter
                    }
                }

                }

                override fun onFailure(call: Call<DiscoverMoviesResponse>, t: Throwable) {

                }
            })
        }
    }
}