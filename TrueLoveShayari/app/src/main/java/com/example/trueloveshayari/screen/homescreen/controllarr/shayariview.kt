package com.example.trueloveshayari.screen.homescreen.controllarr

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trueloveshayari.R
import com.example.trueloveshayari.screen.homescreen.model.ModelData
import com.example.trueloveshayari.screen.homescreen.model.ModelData1
import com.example.trueloveshayari.screen.homescreen.view.ShayariActicity
import com.example.trueloveshayari.utils.Database

data class shayariview(
    val acticity: Activity,
    val list: ArrayList<ModelData>,
) : RecyclerView.Adapter<shayariview.ViewData>() {

    lateinit var db: Database

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quats_img = itemView.findViewById<ImageView>(R.id.quats_img)
        var quats_txt = itemView.findViewById<TextView>(R.id.quats_txt)
        var favourite_img = itemView.findViewById<ImageView>(R.id.favourite_img)
        var Downlode_img = itemView.findViewById<ImageView>(R.id.Downlode_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(acticity).inflate(R.layout.shayariview, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var n = 1

        lateinit var db: Database

        db = Database(acticity)


        holder.quats_txt.text = list[position].shayari_text

        holder.favourite_img.setOnClickListener {

            if(n == 1)
            {
                holder.favourite_img.setImageResource(R.drawable.favourite)
                n=0

            }
            else if(n == 0 )
            {
                holder.favourite_img.setImageResource(R.drawable.unfavourite)
                n=1
            }


        }

        //downlode btn
        holder.Downlode_img.setOnClickListener {

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


}