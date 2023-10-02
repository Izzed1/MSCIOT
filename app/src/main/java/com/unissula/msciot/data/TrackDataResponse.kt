package com.unissula.msciot.data

import com.google.gson.annotations.SerializedName

data class TrackDataResponse(
    @field:SerializedName("status")
    val status: String? = null,
    @field:SerializedName("message")
    val message: String? = null,
    @field:SerializedName("data")
    val data: List<TrackData>? = null

)


