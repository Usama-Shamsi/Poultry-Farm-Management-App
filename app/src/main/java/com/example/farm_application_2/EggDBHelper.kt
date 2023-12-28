package com.example.farm_application_2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EggDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "egg_records.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Create your tables here
        // Create a table for storing egg production record data
        val createEggRecordTableQuery = "CREATE TABLE IF NOT EXISTS egg_records (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "batch_id INTEGER, " +
                "number_of_eggs INTEGER, " +
                "date TEXT);"

        db.execSQL(createEggRecordTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database schema upgrades here if needed
        // Example: You might alter the table or add new tables
        // For simplicity, we are not implementing any upgrades in this example
    }
}
