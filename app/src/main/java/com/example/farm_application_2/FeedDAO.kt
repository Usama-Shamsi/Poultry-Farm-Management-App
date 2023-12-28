package com.example.farm_application_2

import android.content.ContentValues
import android.content.Context
import com.example.farm_application_2.Feed
import com.example.farm_application_2.FeedDBHelper

class FeedDAO(context: Context) {

    private val dbHelper = FeedDBHelper(context)

    fun insertFeedRecord(
        id: Int,
        batchId: Int, // Foreign key from Bird table
        quantity: Int,
        cost: Int,
        date: String
    ) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("id", id)
            put("batchId", batchId)
            put("quantity", quantity)
            put("cost", cost)
            put("date", date)
        }

        db.insert("feed_records", null, values)
        db.close()
    }

    fun getAllFeedRecords(): List<Feed> {
        val feedRecordList = mutableListOf<Feed>()
        val db = dbHelper.readableDatabase

        val columns = arrayOf("id", "batchId", "quantity", "cost", "date")

        db.query("feed_records", columns, null, null, null, null, null).use { cursor ->
            if (cursor == null) {
                return emptyList()
            }

            while (cursor.moveToNext()) {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val batchId = cursor.getInt(cursor.getColumnIndexOrThrow("batchId"))
                val quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"))
                val cost = cursor.getInt(cursor.getColumnIndexOrThrow("cost"))
                val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))

                val feedRecord = Feed(id, batchId, quantity, cost, date)
                feedRecordList.add(feedRecord)
            }
        }
        return feedRecordList
    }
}
