package com.quangtkd.kotlintest.networking

import com.quangtkd.kotlintest.model.CurrentWeather
import com.quangtkd.kotlintest.model.FiveDayWeather
import com.quangtkd.kotlintest.model.Rss
import com.quangtkd.kotlintest.model.UV
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("weather?id=1581130&APPID=db69703d7aa2f2f8337cf62a4b7cae36")
    fun getCurrentWeather(): Observable<Response<CurrentWeather>>

    @GET("forecast?id=1581298&APPID=a06bd2d9f9e95efc1389c40bb16c53cb")
    fun get5DaysWeather(): Observable<Response<FiveDayWeather>>

    @GET("uvi?appid=a06bd2d9f9e95efc1389c40bb16c53cb&lat=21.0245&lon=105.841171")
    fun getUVdata():Observable<Response<UV>>

    @GET( "forecast?id=1581130&APPID=a06bd2d9f9e95efc1389c40bb16c53cb")
    fun get5DaysWeatherHN(): Observable<Response<FiveDayWeather>>

    @GET("forecast?id=1580578&APPID=a06bd2d9f9e95efc1389c40bb16c53cb")
    fun get5DaysWeatherHCM() : Observable<Response<FiveDayWeather>>
}

