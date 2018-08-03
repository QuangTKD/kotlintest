package com.quangtkd.kotlintest.model
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required
import java.util.*

@RealmClass
open class Student(
        @PrimaryKey
        @Required
        var id: String = UUID.randomUUID().toString(),

        @Required
        var name: String = "",

        var age: Int = 0

) : RealmObject()