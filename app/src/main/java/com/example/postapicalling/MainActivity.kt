package com.example.postapicalling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.postapicalling.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val url = "https://reqres.in/api/users"
    var requestQueue :RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestQueue = Volley.newRequestQueue(this)

        binding.btn.setOnClickListener {
            apicalling("Mayank","Android_Developer")
        }

    }
    fun apicalling(name:String,job:String)
    {
        var stringRequest = object : StringRequest(Request.Method.POST,url,Response.Listener{
            response ->
            Toast.makeText(this, "$response", Toast.LENGTH_SHORT).show()
        },Response.ErrorListener{
            error ->             Toast.makeText(this, "$error", Toast.LENGTH_SHORT).show()
        }){
            override fun getParams(): MutableMap<String, String>? {
                var map = HashMap<String,String>()
                map["name"] = "$name"
                map["job"] = "$job"
                return map
            }
        }
        requestQueue?.add(stringRequest)
    }
}