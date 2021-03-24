package com.example.newweatherapp.ui.recycler_stuff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newweatherapp.databinding.ListItemBinding
import com.example.newweatherapp.model.WeatherData
import com.squareup.picasso.Picasso

class RecyclerItemAdapter(private val list: List<WeatherData>) :
    RecyclerView.Adapter<RecyclerItemAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherData) {
            val iconUrl = "https://openweathermap.org/img/w/".plus(item.imageId).plus(".png")

            binding.degrees.text = item.degrees.toString().plus("°C")

            Picasso.with(itemView.context).
            load(iconUrl).
            into(binding.weatherImage)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size
}
