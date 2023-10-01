package com.unissula.msciot.data

import com.google.gson.annotations.SerializedName
import java.util.Date

data class TrackData(

    @field:SerializedName("idUser")
    var idUser: Int?    = null,

    @field:SerializedName("height")
    var height: Int?    = null,

    @field:SerializedName("weight")
    var weight: Int?    = null,

    @field:SerializedName("fat")
    var fat: Int?    = null,

    @field:SerializedName("temprature")
    var temprature: Int?    = null,

    @field:SerializedName("bloodPressure")
    var bloodPressure: Int?    = null,

    @field:SerializedName("dateTime")
    var dateTime: Date? = null

)
