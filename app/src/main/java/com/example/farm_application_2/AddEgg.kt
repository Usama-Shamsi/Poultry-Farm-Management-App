package com.example.farm_application_2

//import EggDAO
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddEgg : AppCompatActivity() {

    private lateinit var batchIdEditText: EditText
    private lateinit var numberOfEggsEditText: EditText
    private lateinit var dateEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_egg) // Use the correct layout resource

        // Access UI components through findViewById
        batchIdEditText = findViewById(R.id.editBatchIdEgg)
        numberOfEggsEditText = findViewById(R.id.editTextNumberOfEggs)
        dateEditText = findViewById(R.id.editTextDateEgg)

        val addButton: Button = findViewById(R.id.btnAddEggProdRecord)
        val backButton: Button = findViewById(R.id.btnAddEggBack)

        addButton.setOnClickListener {
            // Extract values from UI components
            val batchId = batchIdEditText.text.toString().toInt()
            val numberOfEggs = numberOfEggsEditText.text.toString().toInt()
            val date = dateEditText.text.toString()

            // Insert values into the database using your DAO class
            val eggDAO = EggDAO(this)
            eggDAO.insertEggRecord(
                batchId,
                numberOfEggs,
                date
            )

            // After inserting, navigate to the FeedAdapterActivity (or another activity)
            navigateToEggAdapterActivity()
        }

        backButton.setOnClickListener {
            // Handle the click for going back to the previous activity
            finish()
        }
    }

    private fun navigateToEggAdapterActivity() {
        val intent = Intent(this, EggAdapterActivity::class.java)
        startActivity(intent)
    }
}
