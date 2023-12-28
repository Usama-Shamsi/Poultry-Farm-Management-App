/*package com.example.farm_application_2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class BirdAdapterActivity : AppCompatActivity() {
    lateinit var adapter:BirdAdapter
    lateinit var recyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_bird)
        recyclerView = findViewById(R.id.bird_fragment_RecyclerView)
        initAdapter()
    }

    fun initAdapter() {
        val birdRecordDAO = BirdDAO(this)
        val birdRecordList = birdRecordDAO.getAllBirdRecords()
        adapter = BirdAdapter(birdRecordList)
        recyclerView.adapter = adapter
    }
}*/
package com.example.farm_application_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class BirdAdapterActivity : AppCompatActivity() {
    lateinit var adapter: BirdRecyclerView
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_bird) // Set the correct layout file here
        recyclerView = findViewById(R.id.bird_fragment_RecyclerView)
        initAdapter()
    }

    private fun initAdapter() {
        val birdRecordDAO = BirdDAO(this)
        val birdRecordList = birdRecordDAO.getAllBirdRecords()
        adapter = BirdRecyclerView(birdRecordList)
        recyclerView.adapter = adapter
    }
}




