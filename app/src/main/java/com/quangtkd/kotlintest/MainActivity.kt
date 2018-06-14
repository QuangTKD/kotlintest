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

        //create arraylist contain News objects
        var newsArray = ArrayList<News>()

        //create adapter for recycleview
        var myAdapter = NewsAdapter(newsArray)
        //return a Observable object
        ApiUtils.getApiService().getWorldNewsRss()
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
                            Log.d("quangtm", it.toString())
                            for (item in it.body()!!.channel!!.itemList!!){
                                newsArray.add(News(title = item.title!!, summary = item.description!!, url = item.link!!))
                            }
                            //notify for recyclerview that data changed ->reload
                            myAdapter.notifyDataSetChanged()
                        }
                        //request success but no return data
                        else -> Log.d("quangtm", "server error")
                    }
                },
                        //request fail
                {
                })



        //create object linearlayoutmanager
        var layoutManager = LinearLayoutManager(this)

        //set layoutmanager for recycleview
        rv_main.layoutManager = layoutManager
        // set adapter for recycleview
        rv_main.adapter = myAdapter
    }
}
