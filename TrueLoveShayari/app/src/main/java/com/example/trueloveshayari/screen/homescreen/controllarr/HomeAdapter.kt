package com.example.trueloveshayari.screen.homescreen.controllarr

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trueloveshayari.R
import com.example.trueloveshayari.screen.homescreen.model.ModelData
import com.example.trueloveshayari.screen.homescreen.view.MainActivity
import com.example.trueloveshayari.screen.homescreen.view.ShayariActicity
import com.example.trueloveshayari.utils.Database

class HomeAdapter(
    val mainActivity: MainActivity,
    val tital: ArrayList<String>,
    val image: Array<Int>
) : RecyclerView.Adapter<HomeAdapter.viewData>() {


    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tital_txt = itemView.findViewById<TextView>(R.id.tital_txt)
        var bgimage = itemView.findViewById<ImageView>(R.id.bgimage)
        var boxview = itemView.findViewById<RelativeLayout>(R.id.boxview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.item, parent, false)
        return viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {
        holder.tital_txt.text = tital[position]
        holder.bgimage.setImageResource(image[position])



        holder.boxview.setOnClickListener {
            val intent = Intent(mainActivity, ShayariActicity::class.java)
            intent.putExtra("n1",tital[position])
            mainActivity.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return tital.size
    }

}