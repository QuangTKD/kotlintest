package com.quangtkd.kotlintest.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.quangtkd.kotlintest.R
import com.quangtkd.kotlintest.adapter.WeatherAdapter
import com.quangtkd.kotlintest.model.*
import com.quangtkd.kotlintest.networking.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.frag_home.*
import kotlin.math.ceil

class FragHome : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_home, container, false)
    }
    var WeatherArray = ArrayList<WeatherX>()
    var adapter = WeatherAdapter(WeatherArray)



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var layoutManager = LinearLayoutManager(this@FragHome.context)
        rv_frag_home.layoutManager = layoutManager
        rv_frag_home.adapter = adapter


        var fiveDayWeather : FiveDayWeather?

        ApiUtils.getApiService().get5DaysWeatherHCM()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    when (it.code()) {
                        200 -> {
                            fiveDayWeather = it.body()
                            var celsius = ceil(fiveDayWeather?.list?.first()?.main?.temp!! - 273.15)
                            tv_frag_home_temp.text = celsius.toInt().toString()  +"\u00B0"
                            WeatherArray.addAll(ArrayList(fiveDayWeather?.list))

                            val hello = context?.getResources()?.getString(R.string.id_1580578)
                            tv_frag_home_city.text = hello

                            adapter.notifyDataSetChanged()


                        }
                        else -> {
                            Log.d("quangtm", "server error")
                        }
                    }
                },
                        {
                            print(it.message)
                        })



    }
}
