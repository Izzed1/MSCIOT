package com.unissula.msciot

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        // Retrieve the TrackerData object from the intent
        val trackerData = intent.getSerializableExtra("tracker_data") as TrackerData

        // Find the TextViews or other views in your layout where you want to display the data
        val dateTextView = findViewById<TextView>(R.id.tv_date)
        val timeTextView = findViewById<TextView>(R.id.tv_time)
        // Update the views with the data
        dateTextView.text = trackerData.tanggal
        timeTextView.text = trackerData.waktu
        // Add more TextViews for other data fields

        val healthDataItems = listOf(
            HealthDataItem(R.drawable.ic_height, "Height", "170 cm"),
            HealthDataItem(R.drawable.ic_weight, "Weight", "69.6 kg"),
            HealthDataItem(R.drawable.ic_fat, "Fat", "15%"),
            HealthDataItem(R.drawable.ic_blood_pressure, "Blood Pressure", "110/80 mmHg"),
            HealthDataItem(R.drawable.ic_temperature, "Temperature", "36,5°C")
        )
        val rvDataHealth: RecyclerView = findViewById(R.id.rv_data_health)
        val healthDataAdapter = HealthDataAdapter(healthDataItems)

        rvDataHealth.layoutManager = GridLayoutManager(this, 2)
        rvDataHealth.adapter = healthDataAdapter


    }
}