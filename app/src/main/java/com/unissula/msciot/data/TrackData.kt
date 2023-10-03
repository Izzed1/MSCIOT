package com.unissula.msciot.data

import com.google.gson.annotations.SerializedName
import java.util.Date

data class TrackData(

   @field:SerializedName("idUser")
    val idUser: Int? = null,

   @field:SerializedName("height")
    val height:Double? = null,

    @field:SerializedName("weight")
    val weight: Double? = null,

    @field:SerializedName("fat")
    val fat: Double? = null,

    @field:SerializedName("temprature")
    val temprature: Double? = null,

   @field:SerializedName("bloodPressure")
    val bloodPressure: Double? = null,

    @field:SerializedName("createdAt")
    val createdAt: Date? = null,




)

