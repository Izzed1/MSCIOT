package com.unissula.msciot
import java.io.Serializable

data class TrackerData(
    val id: Int,
    val tanggal: String,
    val waktu: String,
    val iconResId: Int,
    val itemName: String,
    val itemValue: String,

) : Serializable
