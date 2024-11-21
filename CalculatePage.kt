package com.example.courseapptest1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.courseapptest1.R

class CalculatePage : AppCompatActivity() {

    // Declare variables for the course layout selections
    private lateinit var layoutChildMinding: LinearLayout
    private lateinit var layoutCooking: LinearLayout
    private lateinit var layoutGarden: LinearLayout
    private lateinit var layoutLand: LinearLayout
    private lateinit var layoutFirstAid: LinearLayout
    private lateinit var layoutLifeSkills: LinearLayout
    private lateinit var layoutSewing: LinearLayout
    private lateinit var viewAmount: TextView
    private lateinit var viewDiscount: TextView
    private lateinit var viewVat: TextView
    private lateinit var viewTotal: TextView

    // Map for storing values of each layout
    private val courseValues = mapOf(
        R.id.layoutChildMinding to 750,
        R.id.layoutCooking to 750,
        R.id.layoutGarden to 750,
        R.id.layoutLand to 1500,
        R.id.layoutFirstAid to 1500,
        R.id.layoutLifeSkills to 1500,
        R.id.layoutSewing to 1500
    )

    // To track selected layouts
    private val selectedLayouts = mutableSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_page)

        // Initialize views
        layoutChildMinding = findViewById(R.id.layoutChildMinding)
        layoutCooking = findViewById(R.id.layoutCooking)
        layoutGarden = findViewById(R.id.layoutGarden)
        layoutLand = findViewById(R.id.layoutLand)
        layoutFirstAid = findViewById(R.id.layoutFirstAid)
        layoutLifeSkills = findViewById(R.id.layoutLifeSkills)
        layoutSewing = findViewById(R.id.layoutSewing)
        viewAmount = findViewById(R.id.viewAmount)
        viewDiscount = findViewById(R.id.viewDiscount)
        viewVat = findViewById(R.id.viewVat)
        viewTotal = findViewById(R.id.viewTotal)

        // Set click listeners on layouts
        setupClickListeners()

        // Calculate button
        findViewById<View>(R.id.btn_calculate).setOnClickListener {
            calculateTotal()
        }
    }

    private fun setupClickListeners() {
        // List of layouts to loop through for setting listeners
        val layouts = listOf(layoutChildMinding, layoutCooking, layoutGarden, layoutLand, layoutFirstAid, layoutLifeSkills, layoutSewing)

        layouts.forEach { layout ->
            layout.setOnClickListener {
                toggleSelection(layout)
            }
        }
    }

    private fun toggleSelection(layout: LinearLayout) {
        val layoutId = layout.id

        if (selectedLayouts.contains(layoutId)) {
            // Deselect if already selected
            layout.setBackgroundResource(R.drawable.selection_card)
            selectedLayouts.remove(layoutId)
        } else {
            // Select the layout
            layout.setBackgroundResource(R.drawable.selected_layout)
            selectedLayouts.add(layoutId)
        }

        // Update displayed amounts
        updateAmounts()
    }

    private fun updateAmounts() {
        // Calculate the total amount of selected layouts
        var totalAmount = selectedLayouts.sumBy { courseValues[it] ?: 0 }

        // Apply discount based on the number of selected layouts
        val discountPercentage = when (selectedLayouts.size) {
            1 -> 0
            2 -> 5
            3 -> 10
            else -> 15
        }

        val discount = (totalAmount * discountPercentage) / 100
        val vat = ((totalAmount - discount) * 15) / 100

        // Update the TextViews with calculated values
        viewAmount.text = "R$totalAmount"
        viewDiscount.text = "R$discount"
        viewVat.text = "R$vat"
    }

    private fun calculateTotal() {
        // Get the current total amount of selected layouts
        var totalAmount = selectedLayouts.sumBy { courseValues[it] ?: 0 }

        // Apply discount based on the number of selected layouts
        val discountPercentage = when (selectedLayouts.size) {
            1 -> 0
            2 -> 5
            3 -> 10
            else -> 15
        }

        val discount = (totalAmount * discountPercentage) / 100
        val vat = ((totalAmount - discount) * 15) / 100

        // Calculate final total
        val finalTotal = totalAmount - discount + vat

        // Display the total amount
        viewTotal.text = "R$finalTotal"
    }


}
