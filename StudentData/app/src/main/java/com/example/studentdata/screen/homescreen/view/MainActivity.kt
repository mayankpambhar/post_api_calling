package com.example.studentdata.screen.homescreen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentdata.databinding.ActivityMainBinding
import com.example.studentdata.screen.homescreen.controller.HomeAdapter
import com.example.studentdata.screen.homescreen.model.ModelData
import com.example.studentdata.utils.Dbhelper

class MainActivity : AppCompatActivity() {

        lateinit var binding: ActivityMainBinding
        var list = arrayListOf<ModelData>()

    lateinit var db : Dbhelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         db = Dbhelper(this)

        list = db.readData()

        setUpRv(list)


    }

    fun setUpRv(list: ArrayList<ModelData>) {

        var adapter = HomeAdapter(this,list)
        var lm = LinearLayoutManager(this)
        binding.view.layoutManager = lm
        binding.view.adapter = adapter

    }

}


