package com.unissula.msciot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.unissula.msciot.data.TrackData
import com.unissula.msciot.data.retrofit.ApiService
import com.unissula.msciot.retrofit.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomeActivity : AppCompatActivity() {

    private lateinit var rv_data_health: RecyclerView
    private lateinit var apiService: ApiService
    private lateinit var trackAdapter: HealthDataAdapter
    lateinit var trackList: ArrayList<TrackData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        trackList = ArrayList()

        rv_data_health = findViewById(R.id.rv_data_health)
        rv_data_health.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false )
        fetchDataTracker()

    }
    private fun fetchDataTracker() {
        // on below line we are creating a retrofit
        // builder and passing our base url
        val retrofit = Retrofit.Builder()
            .baseUrl("https://msciotfix20231001153820.azurewebsites.net")
            // on below line we are calling add
            // Converter factory as Gson converter factory.
            // at last we are building our retrofit builder.
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // below line is to create an instance for our retrofit api class.
        val retrofitAPI = retrofit.create(ApiService::class.java)

        // on below line we are calling a method to get all the courses from API.
        val call: Call<ArrayList<TrackData>?>? = retrofitAPI.getAllDataTracker()

        // on below line we are calling method to enqueue and calling
        // all the data from array list.
        call!!.enqueue(object : Callback<ArrayList<TrackData>?> {
            override fun onResponse(
                call: Call<ArrayList<TrackData>?>,
                response: Response<ArrayList<TrackData>?>
            ) {
                if (response.isSuccessful) {
                    trackList = response.body()!!
                }

                // on below line we are initializing our adapter.
                trackAdapter = HealthDataAdapter(trackList)

                // on below line we are setting adapter to recycler view.
                rv_data_health.adapter = trackAdapter

            }

            override fun onFailure(call: Call<ArrayList<TrackData>?>, t: Throwable) {
                // displaying an error message in toast
                Toast.makeText(this@HomeActivity, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}

