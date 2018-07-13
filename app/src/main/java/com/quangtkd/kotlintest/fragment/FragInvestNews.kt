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
import kotlinx.android.synthetic.main.frag_invest_news.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.ceil


class FragInvestNews : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_invest_news, container, false)


    }

    var WeatherArray = ArrayList<WeatherX>()
    var adapter = WeatherAdapter(WeatherArray)



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var layoutManager = LinearLayoutManager(this@FragInvestNews.context)
        rv_frag_invest_news.layoutManager = layoutManager
        rv_frag_invest_news.adapter = adapter



        var fiveDayWeather : FiveDayWeather?

        ApiUtils.getApiService().get5DaysWeatherHN()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    when (it.code()) {
                        200 -> {
                            fiveDayWeather = it.body()
                            var celsius = ceil(fiveDayWeather?.list?.first()?.main?.temp!! - 273.15)
                            tv_frag_invest_news_city.text = fiveDayWeather?.city?.name
                            tv_frag_invest_news_temp.text = celsius.toInt().toString()  +"\u00B0"
                            WeatherArray.addAll(ArrayList(fiveDayWeather?.list))

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
