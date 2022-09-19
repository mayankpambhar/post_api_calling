package com.example.example_1.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.example_1.Activity.DataBaseModal
import com.example.example_1.Activity.MainActivity
import com.example.example_1.R

class CategoryAdapter(val factivity: MainActivity, var list1: ArrayList<DataBaseModal>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(factivity).inflate(R.layout.quotesview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt.text=list1[position].categoryid
    }

    override fun getItemCount(): Int {
        Log.e("TAG", "getItemCount: "+list1.size )
        return list1.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt = itemView.findViewById<TextView>(R.id.QuotesTxt)
    }
}