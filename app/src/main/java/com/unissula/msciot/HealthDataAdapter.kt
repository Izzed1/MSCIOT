package com.unissula.msciot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HealthDataAdapter(private val items: List<HealthDataItem>) :
    RecyclerView.Adapter<HealthDataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data_health, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleView: TextView = itemView.findViewById(R.id.tv_title_item)
        private val valueView: TextView = itemView.findViewById(R.id.tv_value_item)
        private val iconView: ImageView = itemView.findViewById(R.id.iv_icon_item)
        fun bind(item: HealthDataItem) {
            titleView.text = item.itemName
            valueView.text = item.itemValue
            iconView.setImageResource(item.iconResId)
        }
    }
}
