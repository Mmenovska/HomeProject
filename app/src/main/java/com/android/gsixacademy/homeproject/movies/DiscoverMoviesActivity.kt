package com.android.gsixacademy.homeproject.movies

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.gsixacademy.homeproject.R
import com.android.gsixacademy.homeproject.api.ServiceBuilder
import com.android.gsixacademy.homeproject.api.TheMovieDBApi
import com.android.gsixacademy.homeproject.details.MovieDetailsActivity
import com.android.gsixacademy.homeproject.models.DiscoverMoviesResponse
import com.android.gsixacademy.homeproject.models.DiscoverMoviesResult
import kotlinx.android.synthetic.main.activity_recycler_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscoverMoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val request = ServiceBuilder.buildService(TheMovieDBApi::class.java)
        val call = request.getMovies("8dd3a40cdacd660d79bce7c46bad942e")
        call.enqueue(object  : Callback <DiscoverMoviesResponse> {
            override fun onResponse(
                call: Call<DiscoverMoviesResponse>,
                response: Response<DiscoverMoviesResponse>
            ) { if (response.isSuccessful){
                val discoverMovies = response.body()
                val movieList = discoverMovies?.results
                if (movieList != null){
                    val moviesAdapter = DiscoverMoviesAdapter (movieList){
                        if (it is DiscoverMoviesAdapterClickEvent.DiscoverMoviesItemClicked){
                            startActivity(Intent(applicationContext, MovieDetailsActivity ::class.java ).putExtra("movieName", it.movieResult.title))
                        }
                    }
                    recycler_view_activity.layoutManager = GridLayoutManager (applicationContext,2)
                    recycler_view_activity.adapter = moviesAdapter

                }
            }

            }

            override fun onFailure(call: Call<DiscoverMoviesResponse>, t: Throwable) {

            }
        })
    }
}