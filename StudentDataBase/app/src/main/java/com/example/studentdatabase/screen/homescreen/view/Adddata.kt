package com.example.studentdatabase.screen.homescreen.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studentdatabase.databinding.ActivityAdddataBinding
import com.example.studentdatabase.screen.homescreen.model.ModelData
import com.example.studentdatabase.utils.Dbhelper

class Adddata : AppCompatActivity() {


    lateinit var binding: ActivityAdddataBinding

    var list = arrayListOf<ModelData>()

    lateinit var db: Dbhelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdddataBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.adddataBtn.setOnClickListener {
            db = Dbhelper(this)


            db.insertData(binding.edtName.text.toString(),
                binding.edtSurname.text.toString(),
                binding.edtClass.text.toString(),
                binding.edtStd.text.toString(),
                binding.edtMobile.text.toString())

            list = db.readData()



        }

        binding.filterBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }


}