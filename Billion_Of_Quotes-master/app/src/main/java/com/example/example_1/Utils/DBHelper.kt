package com.example.example_1.Utils

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import android.util.Log
import com.example.example_1.Activity.DataBaseModal
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class DBHelper(val context: Context?) : SQLiteOpenHelper(context, "quotes.db", null, 1) {

    var DBName = "quotes.db"
    var path: String? = null

    init {
        path = if (Build.VERSION.SDK_INT >= 17) {
            context!!.applicationInfo.dataDir + "/databases/"
        } else {
            "/data/data/" + context!!.packageName + "/databases/"
        }
        copyDataBase()
        this.readableDatabase
    }

    override fun onCreate(p0: SQLiteDatabase?) {}

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}

    private fun checkDataBase(): Boolean {
        val dbFile = File(path + DBName)
        return dbFile.exists()
    }

    private fun copyDataBase() {
        if (!checkDataBase()) {
            this.readableDatabase
            close()
            copyDBFile()
        }
    }

    private fun copyDBFile() {
        val mInput = context!!.assets.open(DBName)
        val mOutput: OutputStream = FileOutputStream(path + DBName)
        val mBuffer = ByteArray(1024)
        var mLength: Int
        while (mInput.read(mBuffer).also { mLength = it } > 0) mOutput.write(mBuffer, 0, mLength)
        mOutput.flush()
        mOutput.close()
        mInput.close()
    }

    @SuppressLint("Range")
    fun readData(): ArrayList<DataBaseModal> {
        var db = readableDatabase
        var query = "SELECT * FROM quotes"
        var list2 = arrayListOf<DataBaseModal>()

        var cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                var categoryid = cursor.getString(cursor.getColumnIndex("category_id"))
                var quote = cursor.getString(cursor.getColumnIndex("quote"))

                var l1 = DataBaseModal(categoryid, quote)
                list2.add(l1)
            } while (cursor.moveToNext())
        }
        Log.e("TAG", "readData:count "+list2.size )
        return list2


    }
}