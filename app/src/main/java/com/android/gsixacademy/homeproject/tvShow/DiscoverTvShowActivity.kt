package com.android.gsixacademy.homeproject.tvShow


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.gsixacademy.homeproject.R
import com.android.gsixacademy.homeproject.api.ServiceBuilder
import com.android.gsixacademy.homeproject.api.TheMovieDBApi
import com.android.gsixacademy.homeproject.details.TvShowDetailsActivity
import com.android.gsixacademy.homeproject.models.DiscoverTvShowResponse
import kotlinx.android.synthetic.main.activity_recycler_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscoverTvShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

    val request = ServiceBuilder.buildService(TheMovieDBApi::class.java)
        val call = request.getTvShow("8dd3a40cdacd660d79bce7c46bad942e")
        call.enqueue(object : Callback<DiscoverTvShowResponse>{
            override fun onResponse(
                call: Call<DiscoverTvShowResponse>,
                response: Response<DiscoverTvShowResponse>
            ) { if (response.isSuccessful){
                val tvShow = response.body()
                val tvShowList = tvShow?.results
                if (tvShowList != null){
                    val tvShowAdapter = DiscoverTvShowAdapter (tvShowList){
                        if (it is DiscoverTvShowAdapterClickEvent.discoverTvShowAdapterItemClicked){
                            startActivity(Intent(applicationContext, TvShowDetailsActivity::class.java).putExtra("tvShowName",it.tvShowResult.name))
                        }
                    }
                    recycler_view_activity.layoutManager = GridLayoutManager (applicationContext,2)
                    recycler_view_activity.adapter= tvShowAdapter
                }
            }

            }

            override fun onFailure(call: Call<DiscoverTvShowResponse>, t: Throwable) {

            }
        })
    }
}