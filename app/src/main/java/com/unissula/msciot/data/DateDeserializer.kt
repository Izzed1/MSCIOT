package com.unissula.msciot.data

import com.google.gson.annotations.SerializedName
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.Date

class DateDeserializer : JsonDeserializer<Date> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        val dateStr = json?.asString
        return dateFormat.parse(dateStr)
    }
}