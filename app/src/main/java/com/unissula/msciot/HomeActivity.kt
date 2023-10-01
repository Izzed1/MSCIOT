package com.unissula.msciot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        HealthData()
        HistoryData()
    }

    private fun HealthData() {
        val healthDataItems = listOf(
            HealthDataItem(R.drawable.ic_height, "Height", "170 cm"),
            HealthDataItem(R.drawable.ic_weight, "Weight", "70 kg"),
            HealthDataItem(R.drawable.ic_fat, "Fat", "15%"),
            HealthDataItem(R.drawable.ic_blood_pressure, "Blood Pressure", "120/80 mmHg"),
            HealthDataItem(R.drawable.ic_temperature, "Temperature", "37°C")
        )

        val rvDataHealth: RecyclerView = findViewById(R.id.rv_data_health)
        val healthDataAdapter = HealthDataAdapter(healthDataItems)

        rvDataHealth.layoutManager = GridLayoutManager(this, 2)
        rvDataHealth.adapter = healthDataAdapter
    }

    private fun HistoryData() {
        val trackerDataItems = listOf(
            TrackerData(1,"17 September 2023","17:00","170 Cm","65 Kg","30","120/90","19%"),
            TrackerData(2,"16 September 2023","11:20","170 Cm","65 Kg","30","120/90","19%"),
            TrackerData(3,"15 September 2023","12:06","170 Cm","65 Kg","30","120/90","19%"),
            TrackerData(4,"14 September 2023","08:45","170 Cm","65 Kg","30","120/90","19%"),
            TrackerData(5,"13 September 2023","23:52","170 Cm","65 Kg","30","120/90","19%"),
        )

        val rvTrakerHealth: RecyclerView = findViewById(R.id.rv_history)
        val trackerDataAdapter = TrackerAdapter(trackerDataItems)

        rvTrakerHealth.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTrakerHealth.adapter = trackerDataAdapter
    }
}