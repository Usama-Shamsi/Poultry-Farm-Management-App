package com.example.farm_application_2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class FeedAdapterActivity : AppCompatActivity() {
    lateinit var adapter: FeedRecyclerView
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_feed) // Set the correct layout file here
        recyclerView = findViewById(R.id.feed_fragment_RecyclerView)
        initAdapter()
    }

    private fun initAdapter() {
        val feedRecordDAO = FeedDAO(this)
        val feedRecordList = feedRecordDAO.getAllFeedRecords()
        adapter = FeedRecyclerView(feedRecordList)
        recyclerView.adapter = adapter
    }
}
