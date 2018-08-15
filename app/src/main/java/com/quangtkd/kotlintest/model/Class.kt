package com.quangtkd.kotlintest.model

import io.realm.RealmObject
import io.realm.RealmList
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required
import java.util.*

@RealmClass
open class Class (
        @PrimaryKey
        @Required
        var id : String = UUID.randomUUID().toString(),

        @Required
        var name : String ="",

        var slots: RealmList<Slot> = RealmList(),
        var students: RealmList<Student> = RealmList()

) : RealmObject()