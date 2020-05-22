package com.android.gsixacademy.homeproject.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.homeproject.R
import kotlinx.android.synthetic.main.activity_details.*

class TvShowDetailsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        image_view_back.setOnClickListener { onBackPressed() }

        var tvShowTitle = intent.getStringExtra("tvShowName")
        text_view_name.text = tvShowTitle
    }
}