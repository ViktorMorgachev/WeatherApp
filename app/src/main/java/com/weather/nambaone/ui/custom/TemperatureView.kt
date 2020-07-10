package com.weather.nambaone.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.weather.nambaone.R
import kotlinx.android.synthetic.main.temperature_item.view.*


class TemperatureView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {
    init {
        LayoutInflater.from(context).inflate(R.layout.temperature_item, this, true)
        parseStyle(attributeSet)
    }

    private fun parseStyle(attributeSet: AttributeSet) {
        val styledAttributes =
            context.obtainStyledAttributes(attributeSet, R.styleable.TemperatureView)
        tv_temperature.textSize =
            styledAttributes.getFloat(R.styleable.TemperatureView_android_textSize, 20F)
        ll_background.background =
            styledAttributes.getDrawable(R.styleable.TemperatureView_background)
        styledAttributes.recycle()
    }

    fun setTemperature(temperature: Int){
        // Расчёт и установка фона учитывая температуру
    }

}