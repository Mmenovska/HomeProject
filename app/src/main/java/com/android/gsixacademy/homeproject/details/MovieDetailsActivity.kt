package com.android.gsixacademy.homeproject.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.homeproject.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        image_view_back.setOnClickListener { onBackPressed() }

        val movieTitle = intent.getStringExtra("movieName")
        text_view_name.text = movieTitle

    }
}