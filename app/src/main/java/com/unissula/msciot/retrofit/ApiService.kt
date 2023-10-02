package com.unissula.msciot.data.retrofit

import com.unissula.msciot.data.TrackData
import com.unissula.msciot.data.TrackDataResponse
import com.unissula.msciot.data.retrofit.*
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("api/UserModels")
    suspend fun getDataTracker(): TrackDataResponse

    @GET("api/UserModels")
    fun getAllDataTracker(): Call<ArrayList<TrackData>?>?

}