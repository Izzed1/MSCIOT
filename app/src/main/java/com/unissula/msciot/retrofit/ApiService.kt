package com.unissula.msciot.data.retrofit

import com.unissula.msciot.data.retrofit.*
import com.unissula.msciot.data.TrackDataResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("api/UserModels")
    suspend fun getDataTracker(): TrackDataResponse
}