package com.example.farm_application_2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FeedRecyclerView(var items: List<Feed>) :
    RecyclerView.Adapter<FeedRecyclerView.FeedRecordViewHolder>() {

    class FeedRecordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var id: TextView
        lateinit var batchId: TextView
        lateinit var quantity: TextView
        lateinit var cost: TextView
        lateinit var date: TextView

        init {
            id = view.findViewById(R.id.editFeedId)
            batchId = view.findViewById(R.id.editBatchId)
            quantity = view.findViewById(R.id.editTextQuantity)
            cost = view.findViewById(R.id.editTextCost)
            date = view.findViewById(R.id.editTextDate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedRecordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
        return FeedRecordViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FeedRecordViewHolder, position: Int) {
        val item = items[position]

        holder.id.text = "ID: ${item.id}"
        holder.batchId.text = "Batch ID: ${item.batchId}"
        holder.quantity.text = "Quantity: ${item.quantity}"
        holder.cost.text = "Cost: ${item.cost}"
        holder.date.text = "Date: ${item.date}"
    }
}
