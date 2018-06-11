package com.quangtkd.kotlintest.networking

import com.quangtkd.kotlintest.model.Rss
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/rss/tin-moi-nhat.rss")
    fun getWorldNewsRss(): Observable<Response<Rss>>

    @GET("/rss/suc-khoe.rss")
    fun getHealthNewsRss(): Observable<Response<Rss>>
}