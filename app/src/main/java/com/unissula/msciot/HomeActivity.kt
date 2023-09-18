package com.unissula.msciot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        HealthData()
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
}