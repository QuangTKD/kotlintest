package com.quangtkd.kotlintest.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

import io.realm.annotations.RealmClass
import io.realm.annotations.Required

import java.util.*

@RealmClass
open class Slot (
        @PrimaryKey
        @Required
        var id : String = UUID.randomUUID().toString(),

        @Required
        var name : String ="",

        var duration : Double = 0.0,

        var startTime : Date = Date()

) : RealmObject()