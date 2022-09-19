package com.example.studentdatabase.utils

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import com.example.studentdatabase.screen.homescreen.model.ModelData
import com.example.studentdatabase.screen.homescreen.model.Modeldata2

data class Dbhelper(val context: Context) : SQLiteOpenHelper(context, "AlldataDb.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        var query =
            "CREATE TABLE studentTb (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,surname TEXT,class TEXT,std TEXT,mobile TEXT)";
        db?.execSQL(query)
        var query1 = "CREATE TABLE attendenceTb (id INTEGER PRIMARY KEY AUTOINCREMENT , grid TEXT, pal TEXT, date TEXT)";
        db?.execSQL(query1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {



    }

    fun insertData(n1: String, s1: String, c1: String, s2: String, m1: String) {

        var db = writableDatabase

        var cv = contentValuesOf()
        cv.put("name", n1)
        cv.put("surname", s1)
        cv.put("class", c1)
        cv.put("std", s2)
        cv.put("mobile", m1)

        var res = db.insert("studentTb", null, cv)
        println(res)

    }


    fun insertPA(id:String,num:String){
        var db =  writableDatabase
        var date = "23-6-22"

        var cv = contentValuesOf()
        cv.put("pal",num)
        cv.put("grid",id)
        cv.put("date",date)

        var res = db.insert("attendenceTb",null,cv)
        println("===================================> $res")

    }


    @SuppressLint("Range")
    fun readdata1(): ArrayList<Modeldata2>{

        var list = arrayListOf<Modeldata2>()

        var db = readableDatabase

        var query = "SELECT *FROM attendenceTb"

        var cursor = db.rawQuery(query,null)

        if (cursor.moveToFirst() && cursor.count > 0)
        {
            do {
                var grid = cursor.getString(cursor.getColumnIndex("grid"))
                var pal = cursor.getString(cursor.getColumnIndex("pal"))
                var date = cursor.getString(cursor.getColumnIndex("date"))

                var m2 = Modeldata2(grid,pal,date)
                list.add(m2)
            }while (cursor.moveToNext())
        }
        return list
    }


    @SuppressLint("Range")
    fun readData(): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase


        var query = "SELECT *FROM studentTb "

        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst() && cursor.count > 0) {
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var surname = cursor.getString(cursor.getColumnIndex("surname"))
                var class1 = cursor.getString(cursor.getColumnIndex("class"))
                var std = cursor.getString(cursor.getColumnIndex("std"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))

                var m1 = ModelData(id, name, surname, class1, std, mobile)
                list.add(m1)

            } while (cursor.moveToNext())
        }
        return list
    }

    fun deleteData(id : String)
    {
        var db= writableDatabase
        db.delete("studentTb","id= $id",null)

    }

    fun updateData(id: String, n1: String, s1: String, c1: String, s2: String, m1: String) {

        var db = writableDatabase

        var cv = contentValuesOf()
        cv.put("name", n1)
        cv.put("surname", s1)
        cv.put("class", c1)
        cv.put("std", s2)
        cv.put("mobile", m1)


        db.update("studentTb",cv,"id = $id",null)

    }



    @SuppressLint("Range")
    fun filterData(std: Int): ArrayList<ModelData> {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase


        var query = "SELECT *FROM studentTb where std == '$std' "

        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst() && cursor.count > 0) {
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var name = cursor.getString(cursor.getColumnIndex("name"))
                var surname = cursor.getString(cursor.getColumnIndex("surname"))
                var class1 = cursor.getString(cursor.getColumnIndex("class"))
                var std = cursor.getString(cursor.getColumnIndex("std"))
                var mobile = cursor.getString(cursor.getColumnIndex("mobile"))

                var m1 = ModelData(id, name, surname, class1, std, mobile)
                list.add(m1)

            } while (cursor.moveToNext())
        }

        return list

    }


}

