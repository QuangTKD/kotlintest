package com.quangtkd.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.quangtkd.kotlintest.adapter.NewsAdapter
import com.quangtkd.kotlintest.model.News
import com.quangtkd.kotlintest.networking.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Change something
        var newsArray = ArrayList<News>()

        var myAdapter = NewsAdapter(newsArray)

        ApiUtils.getApiService().getWorldNewsRss()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    when (it.code()) {
                        200 -> {
                            Log.d("quangtm", it.toString())
                            for (item in it.body()!!.channel!!.itemList!!){
                                newsArray.add(News(title = item.title!!, summary = item.description!!, url = item.link!!))
                            }
                            myAdapter.notifyDataSetChanged()
                        }
                        else -> Log.d("quangtm", "server error")
                    }
                },{

                })



        var layoutManager = LinearLayoutManager(this)
        rv_main.layoutManager = layoutManager
        rv_main.adapter = myAdapter
    }
}
