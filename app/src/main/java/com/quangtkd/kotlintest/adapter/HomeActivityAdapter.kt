package com.quangtkd.kotlintest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quangtkd.kotlintest.R
import com.quangtkd.kotlintest.model.Slot
import kotlinx.android.synthetic.main.home_activity_cell.view.*

class HomeActivityAdapter(var slotArray: ArrayList<Slot>) : RecyclerView.Adapter<HomeActivityAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): HomeActivityAdapter.MyViewHolder {
        val cellView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.home_activity_cell, parent, false)

        return MyViewHolder(cellView)
    }

    override fun getItemCount(): Int {
        return slotArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.itemView.home_activity_cell_name.text = slotArray[position].name
       holder.itemView.home_activity_cell_duration.text = slotArray[position].duration.toString()
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}