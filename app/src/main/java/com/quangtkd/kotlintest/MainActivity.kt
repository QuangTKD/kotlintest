package com.quangtkd.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.quangtkd.kotlintest.model.Class
import com.quangtkd.kotlintest.model.Slot
import com.quangtkd.kotlintest.model.Student
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onClick(p0: View?) {
        when (p0!!.id){
            R.id.btn__main_save ->  {
                //Add or update student
                Realm.getDefaultInstance().executeTransaction {
                    it.insertOrUpdate(
                            Student(
                                    name = et_main_name.text.toString(),
                                    age = Integer.parseInt(et_main_age.text.toString())
                            )
                    )
                }
                var studentStr = ""

                //Get All student
                Realm.getDefaultInstance()
                        .where(Student::class.java)
                        .findAll()
                        .forEach {
                            studentStr += "\n ${it.name}"
                        }
                tv_main_student.text = studentStr
            }
            R.id.btn_main_delete -> {
                //Delete all student
                Realm.getDefaultInstance().executeTransaction {
                    it.where(Student::class.java)
                            .findAll()
                            .deleteAllFromRealm()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name = ""


        //Create slots
        var slots = ArrayList<Slot>()
        slots.add(Slot(name = "Math", duration = 45.0))
        slots.add(Slot(name = "Science", duration = 45.0))
        slots.add(Slot(name = "English", duration = 45.0))

        //Create class
        var myClass = Class(name = "101")
        myClass.slots.addAll(slots)

        //Add class into realm database
        Realm.getDefaultInstance().executeTransaction {
            it.insertOrUpdate(myClass)
        }

        //Test reverse relationships
        var className = Realm.getDefaultInstance()
                .where(Slot::class.java)
                .equalTo("name", "Math")
                .findFirst()
                ?.classOwner
                ?.first()
                ?.name

        //Search student by age
        Realm.getDefaultInstance()
                .where(Student::class.java)
                .equalTo("age", Integer.valueOf(0))
                .findAll()
                .forEach {
                    name+= "\n ${it.name}"
                }


        tv_main_search_student.text = name

        btn__main_save.setOnClickListener(this)
        btn_main_delete.setOnClickListener(this)
    }

}
