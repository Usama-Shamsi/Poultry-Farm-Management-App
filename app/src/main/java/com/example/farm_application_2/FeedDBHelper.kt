package com.example.farm_application_2
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class FeedDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "bird_records.db"
        private const val TABLE_NAME = "feed_records"
        private const val COLUMN_ID = "id"
        private const val COLUMN_BATCH_ID = "batch_id"
        private const val COLUMN_QUANTITY = "quantity"
        private const val COLUMN_COST = "cost"
        private const val COLUMN_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createFeedRecordTableQuery = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY," +
                "$COLUMN_BATCH_ID INTEGER," +//foreign key
                "$COLUMN_QUANTITY INTEGER," +
                "$COLUMN_COST INTEGER," +
                "$COLUMN_DATE TEXT);"

        db.execSQL(createFeedRecordTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Upgrade logic goes here if needed
    }
}