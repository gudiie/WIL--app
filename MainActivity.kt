package com.example.courseapptest1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.window.SplashScreen
import android.window.SplashScreenView
import java.util.SplittableRandom

class MainActivity : AppCompatActivity() {
    private val SplashScreen: Long = 30000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }, SplashScreen)
    }
}