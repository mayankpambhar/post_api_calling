package com.example.trueloveshayari.screen.homescreen.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trueloveshayari.databinding.ActivityMainBinding
import com.example.trueloveshayari.screen.homescreen.controllarr.shayariview
import com.example.trueloveshayari.screen.homescreen.model.ModelData
import com.example.trueloveshayari.utils.Database

class ShayariActicity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var list = arrayListOf<ModelData>()
    var n1: String? = ""

    lateinit var db: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        n1 = intent.getStringExtra("n1")
//        Toast.makeText(this,"$n1" ,Toast.LENGTH_LONG)

        db = Database(this)
        list = db.readdata1(n1)
        setUpRv(list)


    }

    fun setUpRv(list: ArrayList<ModelData>) {

        var adapter = shayariview(this,list)
        var lm = LinearLayoutManager(this)
        binding.view.layoutManager = lm
        binding.view.adapter = adapter

    }
}