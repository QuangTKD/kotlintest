package com.quangtkd.kotlintest.networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtils {

    const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    // resignter retrofit
    val retrofit = Retrofit.Builder()
            //bo sung URL
            .baseUrl(BASE_URL)
            //resignter retrofit using obserable pattern
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //decode and encode data from server
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    //return all api u need
    fun getApiService() = retrofit.create(ApiService::class.java)
}