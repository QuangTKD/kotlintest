package com.quangtkd.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import com.quangtkd.kotlintest.adapter.NewsAdapter
import com.quangtkd.kotlintest.fragment.FragEventNews
import com.quangtkd.kotlintest.fragment.FragHome
import com.quangtkd.kotlintest.fragment.FragInvestNews
import com.quangtkd.kotlintest.model.News
import com.quangtkd.kotlintest.networking.ApiUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    val fragHome = FragHome()
    val fragEventNews = FragEventNews()
    val fragInvestNews = FragInvestNews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_bottom_nav_bar.setOnNavigationItemSelectedListener(this)

        supportFragmentManager
                .beginTransaction()
                .apply {
                    replace(R.id.fl_main_container, fragHome)
                    commit()
                }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.action_search -> {
                supportFragmentManager
                        .beginTransaction()
                        .apply {
                            replace(R.id.fl_main_container, fragHome)
                            commit()
                        }
                return true
            }

            R.id.action_settings -> {
                supportFragmentManager
                        .beginTransaction()
                        .apply {
                            replace(R.id.fl_main_container, fragEventNews)
                            commit()
                        }
                return true
            }

            R.id.action_navigation -> {
                supportFragmentManager
                        .beginTransaction()
                        .apply {
                            replace(R.id.fl_main_container, fragInvestNews)
                            commit()
                        }
                return true
            }
        }

        return false
    }
}
