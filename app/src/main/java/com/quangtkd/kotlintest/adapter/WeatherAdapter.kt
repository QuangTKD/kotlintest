package com.quangtkd.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quangtkd.kotlintest.R
import com.quangtkd.kotlintest.model.WeatherX
import kotlinx.android.synthetic.main.weather_recyclerview_cell.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.ceil

class WeatherAdapter(var WeatherArray: ArrayList<WeatherX>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {

        val cellView = LayoutInflater.from(parent.context)
                .inflate(R.layout.weather_recyclerview_cell, parent, false)
           return WeatherViewHolder(cellView)
    }
    override fun getItemCount(): Int {
        return WeatherArray.size
    }


    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        simpleDateFormat.setTimeZone(TimeZone.getDefault())
        val myDate = simpleDateFormat.parse(WeatherArray[position].dtTxt)


        val dateFormat = SimpleDateFormat("EEEE")
        val dayOfWeek = dateFormat.format(myDate)

        var celsius = ceil(WeatherArray[position].main.temp!! - 273.15)

        holder.itemView.tv_weather_cell_temp.text = celsius.toString()
        holder.itemView.tv_weather_cell_day.text = dayOfWeek.toString()

        holder.itemView.setOnClickListener {

        }
    }

    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view)

}