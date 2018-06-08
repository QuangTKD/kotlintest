package com.quangtkd.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quangtkd.kotlintest.R
import com.quangtkd.kotlintest.model.News
import kotlinx.android.synthetic.main.recycler_view_cell.view.*

class NewsAdapter(var newsArray: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create a new view

        val cellView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_cell, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(cellView)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tv_cell_title.text = newsArray[position].title

        holder.itemView.setOnClickListener {

        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}