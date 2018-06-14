package com.quangtkd.kotlintest.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
//open tab
//
@Root(name = "rss", strict=false)
class Rss (
        @field:Attribute(name = "version", required = false)
        @param:Attribute(name = "version", required = false)
        var version: String = "",

        @field:Element(name = "channel")
        var channel: Channel? = null
)