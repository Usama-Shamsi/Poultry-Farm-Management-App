package com.example.farm_application_2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class BirdRecyclerView(var items: List<Bird>) :
    RecyclerView.Adapter<BirdRecyclerView.BirdRecordViewHolder>() {

    class BirdRecordViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var id: TextView
        lateinit var breed: TextView
        lateinit var numberOfBirds: TextView
        lateinit var birdArrivalDate: TextView
        lateinit var ageInDays: TextView
        lateinit var vaccinationStatus: TextView
        val backButton: Button = view.findViewById(R.id.btnFlockBack)
        init {
            id = view.findViewById(R.id.tvItemId)
            breed = view.findViewById(R.id.tvItemBreed)
            numberOfBirds = view.findViewById(R.id.tvItemNumOfBirds)
            birdArrivalDate = view.findViewById(R.id.tvItemArrivalDate)
            ageInDays = view.findViewById(R.id.tvItemAge)
            vaccinationStatus = view.findViewById(R.id.tvItemVaccinationStatus)


            // Set the click listener here
           // backButton.setOnClickListener {
             //    }

        }

       // val intent = Intent(this,AddBird::class.java)
        // startActivity(intent)
        // navigateBackToMainActivity(view.context)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdRecordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bird, parent, false)
        return BirdRecordViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BirdRecordViewHolder, position: Int) {
        val item = items[position]
        holder.id.text = "ID: ${item.id}"
        holder.breed.text = "Breed: ${item.breed}"
        holder.numberOfBirds.text = "Number of Birds: ${item.numberOfBirds}"
        holder.birdArrivalDate.text = "Bird Arrival Date: ${item.birdArrivalDate}"
        holder.ageInDays.text = "Age in Days: ${item.ageInDays}"
        holder.vaccinationStatus.text = "Vaccination Status: ${if (item.vaccinationStatus) "Yes" else "No"}"
    }


}
