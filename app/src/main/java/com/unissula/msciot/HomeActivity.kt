package com.unissula.msciot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unissula.msciot.data.TrackData
import com.unissula.msciot.data.TrackDataResponse
import com.unissula.msciot.data.retrofit.ApiService
import com.unissula.msciot.retrofit.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {

    private lateinit var rv_data_health: RecyclerView
    private lateinit var apiService: ApiService
    private lateinit var trackAdapter: HealthDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        apiService = ApiClient.getInstance()
        rv_data_health = findViewById(R.id.rv_data_health)
        rv_data_health.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false )
        fetchDataTracker()

    }
    private fun fetchDataTracker() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = apiService.getDataTracker()
                if (response.status == "Success") {
                    val trackDataArray = response.data // This is a JSON array

                    // Create an adapter and set the data to the RecyclerView
                    trackAdapter = trackDataArray?.let { HealthDataAdapter(it) }!!
                    rv_data_health.adapter = trackAdapter
                } else {
                    Toast.makeText(this@HomeActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@HomeActivity, "Failed to fetch data", Toast.LENGTH_SHORT).show()
                Log.d("API_FETCH_ERROR", e.toString())
            }
        }
    }

}

