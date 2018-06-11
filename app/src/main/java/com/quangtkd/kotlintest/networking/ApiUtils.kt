package com.quangtkd.kotlintest.networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object ApiUtils {

    const val BASE_URL = "https://vnexpress.net/"

    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()

    fun getApiService() = retrofit.create(ApiService::class.java)
}