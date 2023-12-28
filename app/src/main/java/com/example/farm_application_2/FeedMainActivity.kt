package com.example.farm_application_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class FeedMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_feed)

        val addFeed: Button = findViewById(R.id.btnAddFeed)
        val viewFeed: Button = findViewById(R.id.btnViewFeed)
        val backButton: Button = findViewById(R.id.btnFeedBack)

        addFeed.setOnClickListener {
            // Navigate to Add Feed activity (assuming it's AddFeedActivity)
            val intent = Intent(this, AddFeed::class.java)
            startActivity(intent)
        }

        viewFeed.setOnClickListener {
            // Navigate to Feed Adapter activity (assuming it's FeedAdapterActivity)
            val intent = Intent(this, FeedAdapterActivity::class.java)
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
