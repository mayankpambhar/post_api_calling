package com.example.trueloveshayari.screen.homescreen.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trueloveshayari.R
import com.example.trueloveshayari.databinding.ActivityMainBinding
import com.example.trueloveshayari.screen.homescreen.controllarr.HomeAdapter
import com.example.trueloveshayari.screen.homescreen.model.ModelData
import com.example.trueloveshayari.utils.Database

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var list = arrayListOf<ModelData>()

    var tital = arrayListOf("Morning Shayari","Night Shayari","Birthday Shayari","Love Shayari","Sad Shayari","Bewafa Shayari","Friend Shayari","Attitude Shayari","Funny Shayari","Romantic Shayari"
                            ,"Best Wishes","God Shayari","Yaad Shayari","Other Shayari","Ganesha Shayari","Navratri Shayari","New Year Shayari","All In One",
                            "Christmas Shayari","Kite Shayari","Republic Shayari","Valentine All Shayari","Holi Shayari","Independence Shayari","Janmashtami Shayari"
                            ,"Royal Shayari")

   var image = arrayOf(R.drawable.morning,R.drawable.night,R.drawable.birthday,R.drawable.love,R.drawable.sad,R.drawable.bewafa,R.drawable.friend,R.drawable.attitude
                        ,R.drawable.funny, R.drawable.romantic,R.drawable.bestwish,R.drawable.god,R.drawable.morning,R.drawable.morning,R.drawable.morning
                        ,R.drawable.morning,R.drawable.morning,R.drawable.morning,R.drawable.morning,R.drawable.morning
                        ,R.drawable.morning,R.drawable.morning,R.drawable.morning,R.drawable.morning,R.drawable.morning,R.drawable.morning)


    lateinit var db: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        db = Database(this)

        list = db.readdata()
        setUpRv(list)



    }

    fun setUpRv(list: ArrayList<ModelData>) {

        var adapter = HomeAdapter(this,tital,image)
        var lm = GridLayoutManager(this,3)
        binding.view.layoutManager = lm
        binding.view.adapter = adapter

    }
}