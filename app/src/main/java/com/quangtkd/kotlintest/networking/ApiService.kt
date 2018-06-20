package com.quangtkd.kotlintest.networking

import com.quangtkd.kotlintest.model.Rss
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/rss.php")
    fun getNewsRss(): Observable<Response<Rss>>

    @GET("/rss.php?cat=50")
    fun getInformationRss(): Observable<Response<Rss>>
}