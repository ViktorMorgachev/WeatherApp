package com.weather.nambaone.common

import android.graphics.Color

fun convertTemperatureToColor(temperature: Int): Int {
    val defColorZero = Color.argb(100, 255, 255, 255)
    return when {
        temperature < 0 -> calculateColdColor(temperature)
        temperature > 0 -> calculateWarmColor(temperature)
        else -> defColorZero
    }
}

private fun calculateWarmColor(temperature: Int): Int {
    return Color.argb(100, 228 - (temperature * 2), 118, 58)
}

private fun calculateColdColor(temperature: Int): Int {
    return Color.argb(100, 106, 226 + temperature, 208)
}
