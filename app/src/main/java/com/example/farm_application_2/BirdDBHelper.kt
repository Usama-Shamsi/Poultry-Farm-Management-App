package com.example.farm_application_2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BirdDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "bird_records.db"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Create your tables here
        // Create a table for storing bird record data
        val createBirdRecordTableQuery = "CREATE TABLE IF NOT EXISTS bird_records (" +
                "id INTEGER PRIMARY KEY, " +
                "breed TEXT, " +
                "number_of_birds INTEGER, " +
                "bird_arrival_date TEXT, " +
                "age_in_days INTEGER, " +
                "vaccination_status INTEGER);"

        db.execSQL(createBirdRecordTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database schema upgrades here if needed
        // Example: You might alter the table or add new tables
        // For simplicity, we are not implementing any upgrades in this example
    }
}
