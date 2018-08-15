package com.quangtkd.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.quangtkd.kotlintest.adapter.HomeActivityAdapter
import com.quangtkd.kotlintest.model.Slot
import com.quangtkd.kotlintest.model.Student
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.btn_home_acitvity -> {
                //Add or update student
                Realm.getDefaultInstance().executeTransaction {
                    it.insertOrUpdate(
                            Slot(
                                    name = et_home_acitvity1.text.toString(),
                                    duration = et_home_acitvity2.text.toString().toDouble()
                            )
                    )
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val isEmpty = Realm.getDefaultInstance().where(Slot::class.java).findAll().isEmpty()

        if (isEmpty){
            var slots = ArrayList<Slot>()
            for(i in 0..10){
                slots.add(Slot(name = "Math $i", duration = 45.0))
            }
            Realm.getDefaultInstance().executeTransaction {
                it.insertOrUpdate(slots)
            }

        }
        var slotResult =  Realm.getDefaultInstance()
                .where(Slot::class.java)
                .findAll()

        var slotArray = ArrayList<Slot>()
            slotArray.addAll(slotResult)
        var slotAdapter = HomeActivityAdapter(slotArray)
        var layoutManager = LinearLayoutManager(this)
        rv_home_activity.layoutManager = layoutManager
        rv_home_activity.adapter = slotAdapter

        btn_home_acitvity.setOnClickListener(this)
    }





}
