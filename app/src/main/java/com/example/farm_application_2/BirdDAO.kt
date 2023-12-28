package com.example.farm_application_2

import android.content.ContentValues
import android.content.Context

class BirdDAO(context: Context) {

    private val dbHelper = BirdDBHelper(context)

    fun insertBirdRecord(
        id: Int,
        breed: String,
        numberOfBirds: Int,
        birdArrivalDate: String,
        ageInDays: Int,
        vaccinationStatus: Boolean
    ) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("id", id)
            put("breed", breed)
            put("number_of_birds", numberOfBirds)
            put("bird_arrival_date", birdArrivalDate)
            put("age_in_days", ageInDays)
            put("vaccination_status", if (vaccinationStatus) 1 else 0)
        }

        db.insert("bird_records", null, values)
        db.close()
    }

    fun getAllBirdRecords(): List<Bird> {
        val birdRecordList = mutableListOf<Bird>()

        // Get a readable database instance
        val db = dbHelper.readableDatabase

        // Define the columns you want to retrieve
        val columns = arrayOf(
            "id",
            "breed",
            "number_of_birds",
            "bird_arrival_date",
            "age_in_days",
            "vaccination_status"
        )

        db.query("bird_records", columns, null, null, null, null, null).use { cursor ->
            if (cursor == null) {
                // Handle the case where the cursor is null
                return emptyList()
            }

            // Iterate through the cursor to extract bird record data
            while (cursor.moveToNext()) {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val breed = cursor.getString(cursor.getColumnIndexOrThrow("breed"))
                val numberOfBirds = cursor.getInt(cursor.getColumnIndexOrThrow("number_of_birds"))
                val birdArrivalDate = cursor.getString(cursor.getColumnIndexOrThrow("bird_arrival_date"))
                val ageInDays = cursor.getInt(cursor.getColumnIndexOrThrow("age_in_days"))
                val vaccinationStatus =
                    cursor.getInt(cursor.getColumnIndexOrThrow("vaccination_status")) == 1

                val birdRecord =
                    Bird(id, breed, numberOfBirds, birdArrivalDate, ageInDays, vaccinationStatus)
                birdRecordList.add(birdRecord)
            }

            return birdRecordList
        }
    }
}