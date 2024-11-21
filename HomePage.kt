package com.example.courseapptest1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.LinearLayout

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val btn_Weeks = findViewById<LinearLayout>(R.id.btn_Weeks)
        val btn_Months = findViewById<LinearLayout>(R.id.btn_Months)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation) // Add this line

        // Setting click listeners for the buttons
        btn_Weeks.setOnClickListener {
            val intent = Intent(this, SixWeeksCourses::class.java)
            startActivity(intent)
        }

        btn_Months.setOnClickListener {
            val intentA = Intent(this, SixMonthsCourse::class.java)
            startActivity(intentA)
        }

        // Set up the bottom navigation item selection listener
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeNav -> {
                    val intent = Intent(this, HomePage::class.java)
                    startActivity(intent)
                    true
                }
                R.id.weeksNav -> {
                    val intent = Intent(this, SixWeeksCourses::class.java)
                    startActivity(intent)
                    true
                }
                R.id.monthsNav -> {
                    val intent = Intent(this, SixMonthsCourse::class.java)
                    startActivity(intent)
                    true
                }
                R.id.calculateNav -> {
                    val intent = Intent(this, CalculatePage::class.java)
                    startActivity(intent)
                    true
                }
                R.id.contactNav -> {
                    val intent = Intent(this, ContactPage::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}