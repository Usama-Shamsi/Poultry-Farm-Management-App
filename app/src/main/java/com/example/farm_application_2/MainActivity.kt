package com.example.farm_application_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.farm_application_2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_dashboard, R.id.bird_activity,R.id.egg_activity, R.id.feed_activity
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Set click listeners for the BottomNavigationView items
        navView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_dashboard -> {
                    // Handle the click for Dashboard fragment
                    true
                }
                R.id.bird_activity -> {
                    val intent = Intent(this@MainActivity, BirdMainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.egg_activity -> {
                    val intent = Intent(this@MainActivity, EggMainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.feed_activity -> {
                    val intent = Intent(this@MainActivity, FeedMainActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


        // Set click listener for the bird icon
        binding.navView.findViewById<View>(R.id.bird_activity).setOnClickListener {
            navigateToBirdActivity()
        }
    }

    private fun navigateToBirdActivity() {
        val intent = Intent(this, BirdMainActivity::class.java)
        startActivity(intent)
    }
}

