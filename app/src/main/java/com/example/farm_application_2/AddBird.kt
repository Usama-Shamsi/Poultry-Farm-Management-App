package com.example.farm_application_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddBird : AppCompatActivity() {

    private lateinit var idEditText: EditText
    private lateinit var breedEditText: EditText
    private lateinit var numberOfBird: EditText
    private lateinit var birdArrivalEditText: EditText
    private lateinit var ageInDaysEditText: EditText
    private lateinit var vaccinationStatusCheck: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_bird) // Make sure to use the correct layout resource

        // Access UI components through findViewById
        idEditText = findViewById(R.id.editTextID)
        breedEditText = findViewById(R.id.editTextBreed)
        numberOfBird = findViewById(R.id.editTextNumberOfBirds)
        birdArrivalEditText = findViewById(R.id.editTextNumberOfBirds)
        ageInDaysEditText = findViewById(R.id.editTextAgeInDays)
        vaccinationStatusCheck = findViewById(R.id.checkBoxVaccinationStatus)

        val submitButton: Button = findViewById(R.id.btnSubmitFlock)
        val backButton: Button = findViewById(R.id.btnBackAdd)

        submitButton.setOnClickListener {
            // Extract values from UI components
            val id = idEditText.text.toString().toInt()
            val breed = breedEditText.text.toString()
            val numberOfBirds = numberOfBird.text.toString().toInt()
            val birdArrivalDate = birdArrivalEditText.text.toString()
            val ageInDays = ageInDaysEditText.text.toString().toInt()
            val vaccinationStatus = vaccinationStatusCheck.isChecked

            // Insert values into the database using your DAO class
            val birdDAO = BirdDAO(this)
            birdDAO.insertBirdRecord(
                id,
                breed,
                numberOfBirds,
                birdArrivalDate,
                ageInDays,
                vaccinationStatus
            )

            // After inserting, navigate to the BirdAdapterActivity
            navigateToBirdAdapterActivity()
        }

        backButton.setOnClickListener {
            // Handle the click for going back to the previous activity
            finish()
        }
    }

    private fun navigateToBirdAdapterActivity() {
        val intent = Intent(this, BirdAdapterActivity::class.java)
        startActivity(intent)
    }
}
