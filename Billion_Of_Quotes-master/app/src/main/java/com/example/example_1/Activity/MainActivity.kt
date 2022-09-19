package com.example.example_1.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example_1.Adapter.CategoryAdapter
import com.example.example_1.Utils.DBHelper
import com.example.example_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    var list2 = ArrayList<DataBaseModal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            var db = DBHelper(this)
            list2 = db.readData()
            Log.e("TAG", "onCreate: ==>" + list2.size)
            var adapter = CategoryAdapter(this, list2)
            var layoutManager = LinearLayoutManager(this)
            binding.RvView.layoutManager = layoutManager
            binding.RvView.adapter = adapter

        }

    }

}
