package com.quangtkd.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.quangtkd.kotlintest.model.Slot
import io.realm.Realm

class HomeActivity : AppCompatActivity() {

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

    }
}
