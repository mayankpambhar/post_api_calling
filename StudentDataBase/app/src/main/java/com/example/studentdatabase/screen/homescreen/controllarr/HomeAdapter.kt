package com.example.studentdatabase.screen.homescreen.controllarr

import android.app.Dialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.studentdatabase.R
import com.example.studentdatabase.screen.homescreen.model.ModelData
import com.example.studentdatabase.screen.homescreen.view.MainActivity
import com.example.studentdatabase.screen.homescreen.view.viewAttendence
import com.example.studentdatabase.utils.Dbhelper


data class HomeAdapter(val adddata: MainActivity, val list: ArrayList<ModelData>) : RecyclerView.Adapter<HomeAdapter.viewData>() {

    lateinit var db: Dbhelper

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id_txt = itemView.findViewById<TextView>(R.id.id_txt)
        var name_txt = itemView.findViewById<TextView>(R.id.name_txt)
        var surname_txt = itemView.findViewById<TextView>(R.id.surname_txt)
        var class_txt = itemView.findViewById<TextView>(R.id.class_txt)
        var std_txt = itemView.findViewById<TextView>(R.id.std_txt)
        var mobile_txt = itemView.findViewById<TextView>(R.id.mobile_txt)
        var edit_btn = itemView.findViewById<ImageView>(R.id.edit_btn)
        var delet_btn = itemView.findViewById<ImageView>(R.id.delet_btn)
        var attendence = itemView.findViewById<View>(R.id.attendence)

    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): viewData {
        var view = LayoutInflater.from(adddata).inflate(R.layout.item, parent, false)
        return viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {



        holder.id_txt.text = list[position].id
        holder.name_txt.text = list[position].name
        holder.surname_txt.text = list[position].surname
        holder.class_txt.text = list[position].class1
        holder.std_txt.text = list[position].std
        holder.mobile_txt.text = list[position].mobile

        holder.edit_btn.setOnClickListener {
            updateDialoge(
                list[position].name,
                list[position].surname,
                list[position].class1,
                list[position].std,
                list[position].mobile,
                position
            )

        }

        holder.delet_btn.setOnClickListener {

            Dbhelper(adddata).deleteData(list[position].id)
            var list = Dbhelper(adddata).readData()
            adddata.setUpRv(list)
        }


        holder.attendence.setOnClickListener {




            var dialog = Dialog(adddata)
            dialog.setContentView(R.layout.attendencedialog)
            dialog.show()

            var present_btn = dialog.findViewById<View>(R.id.present_btn)
            var absent_btn = dialog.findViewById<View>(R.id.absent_btn)
            var leave_btn = dialog.findViewById<View>(R.id.leave_btn)
            var viewattendence = dialog.findViewById<View>(R.id.viewattendence)
            db = Dbhelper(adddata)

            var n = list[position].id

            present_btn.setOnClickListener {
                db.insertPA(n,"P")
                dialog.dismiss()
            }
            absent_btn.setOnClickListener {
                db.insertPA(n,"A")
                dialog.dismiss()
            }
            leave_btn.setOnClickListener {
                db.insertPA(n,"L")
                dialog.dismiss()
            }

            viewattendence.setOnClickListener {
                var i = Intent(adddata,viewAttendence::class.java)
                adddata.startActivity(i)
            }

        }
    }
        override fun getItemCount(): Int {
            return list.size
        }

        fun updateDialoge(
            name: String,
            surname: String,
            class1: String,
            std: String,
            mobile: String,
            position: Int
        ) {

            var dialog = Dialog(adddata)
            dialog.setContentView(R.layout.dialog_item)
            dialog.show()

            var edt_update_name = dialog.findViewById<EditText>(R.id.edt_update_name)
            var edt_update_surname = dialog.findViewById<EditText>(R.id.edt_update_surname)
            var edt_update_class = dialog.findViewById<EditText>(R.id.edt_update_class)
            var edt_update_std = dialog.findViewById<EditText>(R.id.edt_update_std)
            var edt_update_mobile = dialog.findViewById<EditText>(R.id.edt_update_mobile)
            var update_btn = dialog.findViewById<Button>(R.id.update_btn)


            edt_update_name.setText(name)
            edt_update_surname.setText(surname)
            edt_update_class.setText(class1)
            edt_update_std.setText(std)
            edt_update_mobile.setText(mobile)


            update_btn.setOnClickListener {

                Dbhelper(adddata).updateData(
                    list[position].id, edt_update_name.text.toString(),
                    edt_update_surname.text.toString(), edt_update_class.text.toString(),
                    edt_update_std.text.toString(), edt_update_mobile.text.toString(),
                )

                var list = Dbhelper(adddata).readData()
                adddata.setUpRv(list)

                dialog.dismiss()

            }

        }

//    fun attendence(id: String): Int {
//        var stats = 0
//
//        var dialog = Dialog(adddata)
//        dialog.setContentView(R.layout.attendencedialog)
//        dialog.show()

}

