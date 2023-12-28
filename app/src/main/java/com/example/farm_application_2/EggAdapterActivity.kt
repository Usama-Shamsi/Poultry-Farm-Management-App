package com.example.farm_application_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class EggAdapterActivity : AppCompatActivity() {
    lateinit var adapter: EggRecyclerView
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_egg) // Set the correct layout file here
        recyclerView = findViewById(R.id.egg_fragment_RecyclerView) // Make sure to use the correct RecyclerView ID
        initAdapter()
    }

    private fun initAdapter() {
        val eggDAO = EggDAO(this)
        val eggProductionList = eggDAO.getAllEggRecords()
        adapter = EggRecyclerView(eggProductionList)
        recyclerView.adapter = adapter
    }
}
