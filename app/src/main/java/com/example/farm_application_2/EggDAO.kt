package com.example.farm_application_2
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.farm_application_2.Egg
import com.example.farm_application_2.EggDBHelper



class EggDAO(context: Context) {

    private val dbHelper = EggDBHelper(context)

    fun insertEggRecord(batchId: Int, numberOfEggs: Int, date: String) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("batch_id", batchId)
            put("number_of_eggs", numberOfEggs)
            put("date", date)
        }

        db.insert("egg_records", null, values)
        db.close()
    }

    fun getAllEggRecords(): List<Egg> {
        val eggList = mutableListOf<Egg>()

        // Get a readable database instance
        val db = dbHelper.readableDatabase

        // Define the columns you want to retrieve
        val columns = arrayOf("batch_id", "number_of_eggs", "date")

        // Execute the query
        db.query("egg_records", columns, null, null, null, null, null).use { cursor ->
            if (cursor == null) {
                // Handle the case where the cursor is null
                return emptyList()
            }

            // Iterate through the cursor to extract egg record data
            while (cursor.moveToNext()) {
                val batchId = cursor.getInt(cursor.getColumnIndexOrThrow("batch_id"))
                val numberOfEggs = cursor.getInt(cursor.getColumnIndexOrThrow("number_of_eggs"))
                val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))

                val egg = Egg(batchId, numberOfEggs, date)
                eggList.add(egg)
            }
        }

        return eggList
    }
}
