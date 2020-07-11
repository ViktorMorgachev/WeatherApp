package com.weather.nambaone.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.weather.nambaone.R
import com.weather.nambaone.common.convertTemperatureToColor
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
            styledAttributes.getFloat(R.styleable.TemperatureView_temperature_textsize, 20F)
        tv_temperature.text = styledAttributes.getString(R.styleable.TemperatureView_temperature)
        ll_background.background =
            styledAttributes.getDrawable(R.styleable.TemperatureView_background)
        styledAttributes.recycle()
    }


    fun setTemperature(temperature: Int) {
        tv_temperature.text = temperature.toString()
        val color = convertTemperatureToColor(temperature)
        ll_background.setBackgroundColor(color)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 100
        val desiredHeight = 100

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        //Measure Width

        //Measure Width
        width = when (widthMode) {
            MeasureSpec.EXACTLY -> {
                //Must be this size
                widthSize
            }
            MeasureSpec.AT_MOST -> {
                //Can't be bigger than...
                desiredWidth.coerceAtMost(widthSize)
            }
            else -> {
                //Be whatever you want
                desiredWidth
            }
        }

        //Measure Height

        //Measure Height
        height = when (heightMode) {
            MeasureSpec.EXACTLY -> {
                //Must be this size
                heightSize
            }
            MeasureSpec.AT_MOST -> {
                //Can't be bigger than...
                desiredHeight.coerceAtMost(heightSize)
            }
            else -> {
                //Be whatever you want
                desiredHeight
            }
        }

        //MUST CALL THIS

        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }
}