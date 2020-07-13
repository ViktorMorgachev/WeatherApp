package com.weather.nambaone.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.weather.nambaone.R
import com.weather.nambaone.data.Weather
import com.weather.nambaone.databinding.WeatherItemBinding

class WeatherAdapter(
    private val items: MutableList<Weather>,
    private val clickItemCallback: ClickItemCallback
) : RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val binding: WeatherItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.weather_item, parent,
            false
        )
        return WeatherHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bind(items[position], clickItemCallback)
    }


    inner class WeatherHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var weatherItemBinding: WeatherItemBinding

        constructor(weatherItemBinding: WeatherItemBinding) : this(weatherItemBinding.root) {
            this.weatherItemBinding = weatherItemBinding
        }

        fun bind(weather: Weather, clickItemCallback: ClickItemCallback) {
            weatherItemBinding.data = weather
            weatherItemBinding.cardView.setOnClickListener {
                clickItemCallback.onItemClicked(weather)
            }
            weatherItemBinding.executePendingBindings()
        }
    }

    interface ClickItemCallback {
        fun onItemClicked(weather: Weather);
    }


}