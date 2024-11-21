package com.example.courseapptest1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SixWeeksCourses : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six_weeks_courses)

        val btn_Child = findViewById<Button>(R.id.btn_Child)
        val btn_Cook = findViewById<Button>(R.id.btn_Cook)
        val btn_Garden = findViewById<Button>(R.id.btn_Garden)

        btn_Child.setOnClickListener {
            val intent = Intent(this, ChildMindingInfo::class.java)
            startActivity(intent)
        }

        btn_Cook.setOnClickListener {
            val intentA = Intent(this, CookingInfo::class.java)
            startActivity(intentA)
        }

        btn_Garden.setOnClickListener {
            val intentB = Intent(this, GardenMaintenanceInfo::class.java)
            startActivity(intentB)
        }
    }
}