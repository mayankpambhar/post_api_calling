package com.example.studentdatabase.screen.homescreen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentdatabase.databinding.ActivityViewAttendenceBinding
import com.example.studentdatabase.screen.homescreen.controllarr.Attendence
import com.example.studentdatabase.screen.homescreen.model.Modeldata2
import com.example.studentdatabase.utils.Dbhelper

class viewAttendence : AppCompatActivity() {

    lateinit var binding: ActivityViewAttendenceBinding

    var list = arrayListOf<Modeldata2>()

    lateinit var db: Dbhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewAttendenceBinding.inflate(layoutInflater)

        setContentView(binding.root)
        db = Dbhelper(this)

        list = db.readdata1()

        setUpRv1(list)


    }

    fun setUpRv1(list: ArrayList<Modeldata2>) {

        var adapter = Attendence(this,list)
        var lm = LinearLayoutManager(this)
        binding.attendenceview.layoutManager = lm
        binding.attendenceview.adapter = adapter

    }
}