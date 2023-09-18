package com.unissula.msciot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TrackerAdapter(private val items: List<TrackerData>) :
    RecyclerView.Adapter<TrackerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tracker, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tanggalView: TextView = itemView.findViewById(R.id.textViewTanggal)
        private val jamView: TextView = itemView.findViewById(R.id.textViewJam)
        fun bind(item: TrackerData) {
            jamView.text = item.waktu
            tanggalView.text = item.tanggal
        }
    }
}
