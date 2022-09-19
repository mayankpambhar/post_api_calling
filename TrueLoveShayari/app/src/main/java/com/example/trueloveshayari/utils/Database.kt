package com.example.trueloveshayari.utils

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.util.Log
import androidx.core.content.contentValuesOf
import com.example.trueloveshayari.screen.homescreen.model.ModelData
import com.example.trueloveshayari.screen.homescreen.model.ModelData1
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream


data class Database(var context: Context?) : SQLiteOpenHelper(context, "Data.db", null, 1){

    var DBNAME = "Data.db"
    var path:String? = null

    init {
        path = if (Build.VERSION.SDK_INT >= 17) {
            context!!.applicationInfo.dataDir + "/databases/"
        } else {
            "/data/data/" + context!!.packageName + "/databases/"
        }
        this.context = context
        this.context = context
        copyDataBase()
        this.readableDatabase
    }

    private fun copyDataBase() {
        if (!checkDataBase()) {
            this.readableDatabase
            close()
            try {
                copyDBFile()
            } catch (mIOException: IOException) {
                throw Error("ErrorCopyingDataBase")
            }
        }
    }

    private fun checkDataBase(): Boolean {
        val dbFile = File(path + DBNAME)
        return dbFile.exists()
    }

    private fun copyDBFile() {
        val mInput = context!!.assets.open(DBNAME)
        val mOutput: OutputStream = FileOutputStream(path + DBNAME)
        val mBuffer = ByteArray(1024)
        var mLength: Int
        while (mInput.read(mBuffer).also { mLength = it } > 0) mOutput.write(mBuffer, 0, mLength)
        mOutput.flush()
        mOutput.close()
        mInput.close()
    }


    override fun onCreate(db: SQLiteDatabase?) {
        var query =
            "CREATE TABLE likeunliketb (id INTEGER PRIMARY KEY AUTOINCREMENT,likeid TEXT )";
        db?.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) { }



    



    @SuppressLint("Range")
    fun readdata(): ArrayList<ModelData>
    {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase

        var query = "SELECT * FROM myShayari"

        var cursor = db.rawQuery(query,null)

        if(cursor.moveToFirst())
        {
            do {
                var shayari_id = cursor.getString(cursor.getColumnIndex("shayari_id"))
                var shayari_text = cursor.getString(cursor.getColumnIndex("shayari_text"))
                var shayari_cate = cursor.getString(cursor.getColumnIndex("shayari_cate"))

                Log.e("TAG", "readdata: $shayari_id $shayari_text $shayari_cate")

                var m1 = ModelData(shayari_id, shayari_text, shayari_cate)
                list.add(m1)

            }while (cursor.moveToNext())
        }
        return list
    }

    @SuppressLint("Range")
    fun readdata1(n: String?): ArrayList<ModelData>
    {

        var list = arrayListOf<ModelData>()

        var db = readableDatabase

        var query = "SELECT * FROM myShayari where shayari_cate == '$n'"

        var cursor = db.rawQuery(query,null)

        if(cursor.moveToFirst())
        {
            do {
                var shayari_id = cursor.getString(cursor.getColumnIndex("shayari_id"))
                var shayari_text = cursor.getString(cursor.getColumnIndex("shayari_text"))
                var shayari_cate = cursor.getString(cursor.getColumnIndex("shayari_cate"))

                Log.e("TAG", "readdata: $shayari_id $shayari_text $shayari_cate")

                var m1 = ModelData(shayari_id, shayari_text, shayari_cate)
                list.add(m1)

            }while (cursor.moveToNext())
        }
        return list
    }



}

