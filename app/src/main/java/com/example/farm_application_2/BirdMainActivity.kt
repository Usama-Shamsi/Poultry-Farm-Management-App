package com.example.farm_application_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class BirdMainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_bird)

        val addFlock: Button = findViewById(R.id.btnAddBatch)
        val viewFlock: Button = findViewById(R.id.btnViewBatch)
        val backButton: Button = findViewById(R.id.btnFlockBack)

        addFlock.setOnClickListener {
            // Navigate to Add Batch activity (assuming it's AddBatchActivity)
            val intent = Intent(this, AddBird::class.java)
            startActivity(intent)
        }

        viewFlock.setOnClickListener {
            // Navigate to Add Bird activity (assuming it's AddBirdActivity)
            val intent = Intent(this,BirdAdapterActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            // Navigate back to the previous activity (MainActivity)
            navigateBackToMainActivity()
        }
    }

    private fun navigateBackToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // finish the current activity
    }
}
