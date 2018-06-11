package com.quangtkd.kotlintest.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

@NamespaceList(Namespace(reference = "http://www.w3.org/2005/Atom", prefix = "atom"))
@Root(name = "channel", strict = false)
class Channel (
        // Tricky part in Simple XML because the link is named twice
        @field:ElementList(entry = "link", inline = true, required = false)
        var links: List<String>? = null,

        @field:ElementList(name = "item", required = true, inline = true)
        var itemList: List<Item>? = null,

        @field:Element(name = "title", required = false)
        var title: String? = null,

        @field:Element(name = "language", required = false)
        var language: String? = null

)

@Root(name = "item", strict = false)
class Item (

        @field:Element(name = "title", required = true)
        var title: String? = null,//The title of the item.	Venice Film Festival Tries to Quit Sinking
        @field:Element(name = "link", required = true)
        var link: String? = null,//The URL of the item.	http://www.nytimes.com/2002/09/07/movies/07FEST.html
        @field:Element(name = "description", required = true)
        var description: String? = null,//The item synopsis.	Some of the most heated chatter at the Venice Film Festival this week was about the way that the arrival of the stars at the Palazzo del Cinema was being staged.
        @field:Element(name = "guid", required = false)
        var guid: String? = null,//A string that uniquely identifies the item. More.	<guid isPermaLink="true">http://inessential.com/2002/09/01.php#a2</guid>
        @field:Element(name = "pubDate", required = false)
        var pubDate: String? = null//	Indicates when the item was published. More.	Sun, 19 May 2002 15:21:36 GMT

)
