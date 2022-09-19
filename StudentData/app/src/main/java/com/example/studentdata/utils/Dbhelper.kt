package com.example.studentdata.utils

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.LocusId
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import com.example.studentdata.screen.homescreen.model.ModelData

data class Dbhelper(val context: Context?) : SQLiteOpenHelper(context, "AlldataDb.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}
