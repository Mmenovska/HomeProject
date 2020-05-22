package com.android.gsixacademy.homeproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        GlobalScope.launch {
            Thread.sleep(2000)
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }
}