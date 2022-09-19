package com.example.studentdatabase.screen.homescreen.controllarr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentdatabase.R
import com.example.studentdatabase.screen.homescreen.model.ModelData
import com.example.studentdatabase.screen.homescreen.model.Modeldata2
import com.example.studentdatabase.screen.homescreen.view.viewAttendence

class Attendence(val viewAttendence: viewAttendence, val list: ArrayList<Modeldata2>) : RecyclerView.Adapter<Attendence.viewData>() {

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var grid_txt = itemView.findViewById<TextView>(R.id.grid_txt)
        var pal_txt = itemView.findViewById<TextView>(R.id.pal_txt)
        var date_txt = itemView.findViewById<TextView>(R.id.date_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {
        var view = LayoutInflater.from(viewAttendence).inflate(R.layout.item2, parent, false)
        return Attendence.viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {

        holder.grid_txt.text = list[position].grid
        holder.pal_txt.text = list[position].pal
        holder.date_txt.text = list[position].date

    }

    override fun getItemCount(): Int {
        return list.size
    }
}