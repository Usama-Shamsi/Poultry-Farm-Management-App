package com.example.farm_application_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EggMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_egg)

        val addEggButton: Button = findViewById(R.id.btnAddEgg)
        val viewEggButton: Button = findViewById(R.id.btnViewEgg)
        val backButton: Button = findViewById(R.id.btnAddBackEgg)

        addEggButton.setOnClickListener {
            // Navigate to Add Egg activity (assuming it's AddEggActivity)
            val intent = Intent(this, AddEgg::class.java)
            startActivity(intent)
        }

        viewEggButton.setOnClickListener {
            // Navigate to Egg Adapter activity (assuming it's EggAdapterActivity)
            val intent = Intent(this, EggAdapterActivity::class.java)
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
