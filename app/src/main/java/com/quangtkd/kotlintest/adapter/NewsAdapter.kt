package com.quangtkd.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quangtkd.kotlintest.R
import com.quangtkd.kotlintest.model.News
import kotlinx.android.synthetic.main.recycler_view_cell.view.*
//oop : tinh bao dong tih truu tuong, tinh ke thua, tinh da hinh
//tinh ke thua : class con thua huong toan bo dac tinh va phuong thuc cua class cha
//tinh truu tuong : class animal (lop truu tuong) -> class cat, class dog (class con) class animal k co instant
//tinh bao dong : class (attributes, function), function (k anh huong den kq function khac, chi thuc hienj 1 cv)
//tinh da hinh : class con -> class cha
//concrete class : normal class
//abstract class : stand for "is"
//interface : stannd "can do "
//newsadapter extend recyclerview.adapter, recyclerview adapter is a bridge of data and view
//newadapter's constructer : contain a parameter which is a arraylist of news
 class NewsAdapter(var newsArray: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){

    private var context: Context? = null
    //register return a celllayout for recyclerview
    //parent is an instant which is viewgroup type, it is the view that contain recyclerview
    //view type is a integer variable it help recyclerview detech what layout for recent cell
    //return type : myviewholder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //Layoutinflater is object  that pump layout into view object
        //from ( parent.context) defind where the layout is lay in
        //inflate pump layout into view
        // 1st parameter : layout cell, 2nd para : parent in viewgroup, 3rd para : correct cell view coordinater by refer to parent coordinater
        val cellView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_cell, parent, false)
        // return myview object
        return MyViewHolder(cellView)
    }
    //return number of newarray for notifying recyclerview that it need to display how many cell
    override fun getItemCount(): Int {
        return newsArray.size
    }

    //set data for each of cell in recyclerview
    //1st para is holder and have myviewholder type,2nd para is position and have int type
    //holder have cell layout type for recyclerview cell at position
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //set text for textview at cell and value is object at position in newarray
        holder.itemView.tv_cell_title.text = newsArray[position].title
        //set onclicklistener for cell
        holder.itemView.setOnClickListener {

        }
    }
    // recyclerview cell layout
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}