package com.example.farm_application_2
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddFeed : AppCompatActivity() {

    private lateinit var batchIdEditText: EditText
    private lateinit var flockIdEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var quantityEditText: EditText
    private lateinit var costEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_feed)

        // Access UI components through findViewById
        flockIdEditText = findViewById(R.id.editFeedId)
        batchIdEditText = findViewById(R.id.editBatchId)
        quantityEditText =findViewById(R.id.editTextQuantity)
        costEditText = findViewById(R.id.editTextCost)
        dateEditText = findViewById(R.id.editTextDate)

        val addButton: Button = findViewById(R.id.btnSubmitFeedRecord)
        val backButton: Button = findViewById(R.id.btnAddFeedBack)

        addButton.setOnClickListener {
            // Extract values from UI components
            val feedId = flockIdEditText.text.toString().toInt()
            val batchId = batchIdEditText.text.toString().toInt()
            val quantity = quantityEditText.text.toString().toInt()
            val cost = costEditText.toString().toInt()
            val date = dateEditText.text.toString()

            // Insert values into the database using your DAO class
            val eggDAO = FeedDAO(this)
            eggDAO.insertFeedRecord(
                feedId,
                batchId,
                quantity,
                cost,
                date
            )

            // After inserting, navigate to the FeedAdapterActivity (or another activity)
            navigateToFeedAdapterActivity()
        }

        backButton.setOnClickListener {
            // Handle the click for going back to the previous activity
            finish()
        }
    }

    private fun navigateToFeedAdapterActivity() {
        val intent = Intent(this, FeedAdapterActivity::class.java)
        startActivity(intent)
    }
}
