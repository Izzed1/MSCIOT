package com.unissula.msciot.data

import com.google.gson.annotations.SerializedName
import java.util.Date

data class TrackData(

   // @field:SerializedName("idUser")
    val idUser: Int,

   // @field:SerializedName("height")
    val height:Double,

    //@field:SerializedName("weight")
    val weight: Double,

    //@field:SerializedName("fat")
    val fat: Double,

    //@field:SerializedName("temprature")
    val temprature: Double,

   // @field:SerializedName("bloodPressure")
    val bloodPressure: Double,

    //@field:SerializedName("createdAt")
    val createdAt: Date,




)
