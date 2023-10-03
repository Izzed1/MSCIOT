package com.unissula.msciot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unissula.msciot.data.TrackData
import com.unissula.msciot.data.TrackDataResponse
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class HealthDataAdapter(private var trackData: List<TrackData>) : RecyclerView.Adapter<HealthDataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data_health, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trackItem = trackData[position]
        holder.bind(trackItem)
        val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss", Locale.US) // Set locale to English (United States)
        dateFormat.timeZone = TimeZone.getTimeZone("GMT+7") // Atur zona waktu ke GMT+7
        val formattedDate = dateFormat.format(trackItem.createdAt)

        holder.dateTextView.text = formattedDate
    }

    override fun getItemCount(): Int {
        return trackData.size
    }
    fun updateData(newData: List<TrackData>) {
        trackData = newData
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.tv_date)
        private val heightTextView: TextView = itemView.findViewById(R.id.tv_height)
        private val weightTextView: TextView = itemView.findViewById(R.id.tv_weight)
        private val fatTextView: TextView = itemView.findViewById(R.id.tv_fat)
        private val tempratureTextView: TextView = itemView.findViewById(R.id.tv_temperature)
        private val bloodPressureTextView: TextView = itemView.findViewById(R.id.tv_blood_pleasure)

        fun bind(trackData: TrackData) {
            dateTextView.text = trackData.createdAt.toString()
            heightTextView.text = trackData.height.toString()
            weightTextView.text = trackData.weight.toString()
            fatTextView.text = trackData.fat.toString()
            tempratureTextView.text = trackData.temprature.toString()
            bloodPressureTextView.text = trackData.bloodPressure.toString()

        }
    }
}