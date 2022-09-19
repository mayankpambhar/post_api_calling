package com.example.studentdata.screen.homescreen.controller

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentdata.R
import com.example.studentdata.screen.homescreen.model.ModelData
import com.example.studentdata.screen.homescreen.view.MainActivity
import com.example.studentdata.utils.Dbhelper

data class HomeAdapter(val mainActivity: MainActivity, val list: ArrayList<ModelData>) : RecyclerView.Adapter<HomeAdapter.viewData>() {
    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id_txt = itemView.findViewById<TextView>(R.id.id_txt)
        var name_txt = itemView.findViewById<TextView>(R.id.name_txt)
        var class_txt = itemView.findViewById<TextView>(R.id.class_txt)
        var std_txt = itemView.findViewById<TextView>(R.id.std_txt)
        var attendence_txt = itemView.findViewById<TextView>(R.id.attendence_txt)
        var leave_txt = itemView.findViewById<TextView>(R.id.leave_txt)
        var edit_btn = itemView.findViewById<ImageView>(R.id.edit_btn)
        var delet_btn = itemView.findViewById<ImageView>(R.id.delet_btn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.item, parent, false)
        return viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {

        holder.id_txt.text = list[position].id
        holder.name_txt.text = list[position].name
        holder.class_txt.text = list[position].class1
        holder.std_txt.text = list[position].std
        holder.attendence_txt.text = list[position].attendence
        holder.leave_txt.text = list[position].leave



        holder.edit_btn.setOnClickListener {
            updateDialoge(list[position].name,list[position].class1,list[position].std,list[position].attendence,list[position].leave,position)

        }

        holder.delet_btn.setOnClickListener {

            Dbhelper(mainActivity).deleteData(list[position].id)
            var list = Dbhelper(mainActivity).readData()
            mainActivity.setUpRv(list)
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDialoge(name:String,class1:String,std:String,attendence:String,leave:String,position: Int) {

        var dialog = Dialog(mainActivity)
        dialog.setContentView(R.layout.dialog_item)
        dialog.show()

        var edt_update_name = dialog.findViewById<EditText>(R.id.edt_update_name)
        var edt_update_class = dialog.findViewById<EditText>(R.id.edt_update_class)
        var edt_update_std = dialog.findViewById<EditText>(R.id.edt_update_std)
        var edt_update_attendence = dialog.findViewById<EditText>(R.id.edt_update_attendence)
        var edt_update_leave = dialog.findViewById<EditText>(R.id.edt_update_leave)
        var update_btn = dialog.findViewById<Button>(R.id.update_btn)


        edt_update_name.setText(name)
        edt_update_class.setText(class1)
        edt_update_std.setText(std)
        edt_update_attendence.setText(attendence)
        edt_update_leave.setText(leave)

        update_btn.setOnClickListener {

            Dbhelper(mainActivity).updateData(list[position].id,edt_update_name.text.toString(),
            edt_update_class.text.toString(),edt_update_std.text.toString(),edt_update_attendence.text.toString(),
            edt_update_leave.text.toString())

            var list =  Dbhelper(mainActivity).readData()
            mainActivity.setUpRv(list)

            dialog.dismiss()

        }

    }
}



