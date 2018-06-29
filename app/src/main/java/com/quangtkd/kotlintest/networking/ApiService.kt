package com.quangtkd.kotlintest.networking

import com.quangtkd.kotlintest.model.CurrentWeather
import com.quangtkd.kotlintest.model.Rss
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("weather?id=1581130&APPID=db69703d7aa2f2f8337cf62a4b7cae36")
    fun getLocalNewsRss(): Observable<Response<CurrentWeather>>
}