package com.example.postapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.postapi.databinding.ActivityMainBinding
import java.lang.ref.ReferenceQueue

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var link = "https://jsonplaceholder.typicode.com/posts"
    var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.testBtn.setOnClickListener {
            apiCalling()
        }


    }

    fun apiCalling() {


        requestQueue = Volley.newRequestQueue(this)

        var jsonArrayRequest = JsonArrayRequest(Request.Method.GET, link, null,
        Response.Listener { response ->

           Log.e("TAG","apiCalling:${response.getJSONArray(0)}")

        },
        Response.ErrorListener{ error ->

            Log.e("TAG","apiCalling: ${error.message}")

        })

        requestQueue?.add(jsonArrayRequest)


    }
}