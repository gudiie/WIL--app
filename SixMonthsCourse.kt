package com.example.courseapptest1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SixMonthsCourse : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six_months_course)

        val btn_Aid = findViewById<Button>(R.id.btn_Aid)
        val btn_Sewing =findViewById<Button>(R.id.btn_Sewing)
        val btn_Scaping =findViewById<Button>(R.id.btn_scaping)
        val btn_Life =findViewById<Button>(R.id.btn_Life)

        btn_Aid.setOnClickListener {
            val intent = Intent(this,firstAidInfo::class.java)
            startActivity(intent)
        }

        btn_Sewing.setOnClickListener {
            val intent =Intent(this,SewingInfo::class.java)
            startActivity(intent)
        }

        btn_Scaping.setOnClickListener {
            val intent =Intent(this,LandscapingInfo::class.java)
            startActivity(intent)
        }

        btn_Life.setOnClickListener {
            val intent =Intent(this,LifeSkillsInfo::class.java)
            startActivity(intent)
        }
    }
}