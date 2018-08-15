package com.quangtkd.kotlintest.model

import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey

import io.realm.annotations.RealmClass
import io.realm.annotations.Required
import java.nio.file.attribute.FileOwnerAttributeView

import java.util.*

@RealmClass
open class Slot (
        @PrimaryKey
        @Required
        var id : String = UUID.randomUUID().toString(),

        @Required
        var name : String ="",

        var duration : Double = 0.0,

        var startTime : Date = Date(),

        //Defind reverse relationship
        //Linking object name is the name of slot array in class table
        @LinkingObjects("slots")
        val classOwner: RealmResults<Class>? = null




) : RealmObject()