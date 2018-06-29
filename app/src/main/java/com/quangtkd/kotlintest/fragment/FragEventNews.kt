package com.quangtkd.kotlintest.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.quangtkd.kotlintest.R
import com.quangtkd.kotlintest.adapter.NewsAdapter
import com.quangtkd.kotlintest.model.CurrentWeather
import com.quangtkd.kotlintest.model.News
import com.quangtkd.kotlintest.networking.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.frag_event_news.*

class FragEventNews : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_event_news, container, false)
    }

    var newArray = ArrayList<News>()
    var adapter = NewsAdapter(newArray)



    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var layoutManager = LinearLayoutManager(this@FragEventNews.context)
        rv_frag_event_news.layoutManager = layoutManager
        rv_frag_event_news.adapter = adapter

        var currentWeather: CurrentWeather?

        ApiUtils.getApiService().getLocalNewsRss()
                //where the Observable perform on newthread
                .subscribeOn(Schedulers.newThread())
                //listen data of observable after finish on newthread to the mainthread
                .observeOn(AndroidSchedulers.mainThread())
                // 4 function : onnext, onerror
                .subscribe({
                    // code : reponse status
                    //detech request success or not
                    when (it.code()) {
                    //request success
                        200 -> {
                            currentWeather = it.body()
                        }
                    //request success but no return data
                        else -> {
                            Log.d("quangtm", "server error")
                        }
                    }
                },
                        //request fail
                        {
                            print(it.message)
                        })
    }



}
