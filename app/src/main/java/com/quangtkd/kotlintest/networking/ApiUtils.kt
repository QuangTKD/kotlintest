package com.quangtkd.kotlintest.networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object ApiUtils {

    const val BASE_URL = "http://vietnamtourism.gov.vn/"
    // resignter retrofit
    val retrofit = Retrofit.Builder()
            //bo sung URL
            .baseUrl(BASE_URL)
            //resignter retrofit using obserable pattern
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //decode and encode data from server
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    //return all api u need
    fun getApiService() = retrofit.create(ApiService::class.java)
}