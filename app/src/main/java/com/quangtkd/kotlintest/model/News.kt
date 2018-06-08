package com.quangtkd.kotlintest.model

import java.util.*

class News(
        var id: String = UUID.randomUUID().toString(),
        var title: String = "",
        var summary: String = "",
        var content: String = "",
        var read: Int = 0,
        var publishDate: String = "",
        var url: String = ""
)