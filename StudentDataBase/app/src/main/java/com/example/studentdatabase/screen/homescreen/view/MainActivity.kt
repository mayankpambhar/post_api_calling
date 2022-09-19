package com.example.studentdatabase.screen.homescreen.view

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentdatabase.R
import com.example.studentdatabase.databinding.ActivityMainBinding
import com.example.studentdatabase.screen.homescreen.controllarr.HomeAdapter
import com.example.studentdatabase.screen.homescreen.model.ModelData
import com.example.studentdatabase.utils.Dbhelper

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var list = arrayListOf<ModelData>()

    lateinit var db: Dbhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Dbhelper(this)

        list = db.readData()
        setUpRv(list)

        binding.filter.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.choise_item)
            dialog.show()

            var std1 = dialog.findViewById<TextView>(R.id.std1)
            var std2 = dialog.findViewById<TextView>(R.id.std2)
            var std3 = dialog.findViewById<TextView>(R.id.std3)
            var std4 = dialog.findViewById<TextView>(R.id.std4)
            var std5 = dialog.findViewById<TextView>(R.id.std5)
            var std6 = dialog.findViewById<TextView>(R.id.std6)
            var std7 = dialog.findViewById<TextView>(R.id.std7)
            var std8 = dialog.findViewById<TextView>(R.id.std8)
            var std9 = dialog.findViewById<TextView>(R.id.std9)
            var std10 = dialog.findViewById<TextView>(R.id.std10)
            var std11 = dialog.findViewById<TextView>(R.id.std11)
            var std12 = dialog.findViewById<TextView>(R.id.std12)
            var alldata = dialog.findViewById<TextView>(R.id.alldata)

            alldata.setOnClickListener{

                list = db.readData()
                setUpRv(list)
            }

            std1.setOnClickListener{

                var std =1
                list = db.filterData(std)
                setUpRv(list)
            }

            std2.setOnClickListener{

                var std =2
                list = db.filterData(std)
                setUpRv(list)
            }

            std3.setOnClickListener{

                var std =3
                list = db.filterData(std)
                setUpRv(list)
            }

            std4.setOnClickListener{

                var std =4
                list = db.filterData(std)
                setUpRv(list)
            }

            std5.setOnClickListener{

                var std =5
                list = db.filterData(std)
                setUpRv(list)
            }

            std6.setOnClickListener{

                var std =6
                list = db.filterData(std)
                setUpRv(list)
            }

            std7.setOnClickListener{

                var std =7
                list = db.filterData(std)
                setUpRv(list)
            }

            std8.setOnClickListener{

                var std =8
                list = db.filterData(std)
                setUpRv(list)
            }

            std9.setOnClickListener{

                var std =9
                list = db.filterData(std)
                setUpRv(list)
            }

            std10.setOnClickListener{

                var std =10
                list = db.filterData(std)
                setUpRv(list)
            }

            std11.setOnClickListener{

                var std =11
                list = db.filterData(std)
                setUpRv(list)
            }

            std12.setOnClickListener{

                var std =12
                list = db.filterData(std)
                setUpRv(list)
            }

        }



    }

    fun setUpRv(list: ArrayList<ModelData>) {

        var adapter = HomeAdapter(this,list)
        var lm = LinearLayoutManager(this)
        binding.rvview.layoutManager = lm
        binding.rvview.adapter = adapter

    }

}