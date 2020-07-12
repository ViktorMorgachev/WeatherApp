package com.weather.nambaone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.weather.nambaone.data.Weather
import com.weather.nambaone.databinding.ActivityMainBinding
import com.weather.nambaone.ui.WeatherAdapter

class MainActivity : AppCompatActivity(), WeatherAdapter.ClickItemCallback {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        populateData()
    }

    private fun populateData() {
        val weatherAdapter = WeatherAdapter(mutableListOf(), this)
        mainBinding.myAdapter = weatherAdapter
    }

    override fun onItemClicked(weather: Weather) {

    }

}